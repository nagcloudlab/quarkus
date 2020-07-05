package org.acme.quarkus.sample.service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

import javax.enterprise.context.ApplicationScoped;
import javax.json.bind.Jsonb;
import javax.json.bind.JsonbBuilder;
import javax.transaction.Transactional;

import org.acme.quarkus.sample.model.Account;
import org.acme.quarkus.sample.model.Txn;
import org.eclipse.microprofile.faulttolerance.Asynchronous;
import org.eclipse.microprofile.faulttolerance.Bulkhead;
import org.eclipse.microprofile.reactive.messaging.Outgoing;

import io.reactivex.Flowable;

@ApplicationScoped
public class TxrService {

//	@Gauge(name = "peakOfTxrs",unit = MetricUnits.SECONDS,description = "Highest number os txrs")
//	@Timed(name = "txr time check",description = "how much time it takes to dlo txr")
//	@Counted(absolute = true, description = "txr count")
//	@Timeout(250)
//	@Fallback(fallbackMethod = "doLocalTxr")
//	@Retry(maxRetries = 3,retryOn = {RuntimeException.class})
//	@CircuitBreaker(successThreshold = 5, requestVolumeThreshold = 4, failureRatio = 0.75, delay = 3000,failOn = {RuntimeException.class})
//	@RolesAllowed(value = { "USER" })

	BlockingQueue<Txn> blockingQueue = new ArrayBlockingQueue<Txn>(1000);

	@Transactional
	public void txr(double amount, String fromAccNumber, String toAccNumber) {

		System.out.println("txr");

		// randomSleep();
		// possibleFailure();

		Account fromAccount = Account.findById(fromAccNumber);
		Account toAccount = Account.findById(toAccNumber);

		fromAccount.setBalance(fromAccount.getBalance() - amount);
		toAccount.setBalance(toAccount.getBalance() + amount);

		Account.update("balance=?1 where num=?2", fromAccount.getBalance(), fromAccount.getNum());
		Account.update("balance=?1 where num=?2", toAccount.getBalance(), toAccount.getNum());

		// writeSomeLogging(); /
	}

	private Random random = new Random();
	@Outgoing("number-stream")
	public Flowable<Integer> publishTxn() {
		return Flowable.interval(2, TimeUnit.SECONDS)
                .map(tick -> random.nextInt(100));
	}

	@Asynchronous
	@Bulkhead(value = 5, waitingTaskQueue = 10)
	public Future<String> writeSomeLogging() {
		System.out.println("LOG");
		return CompletableFuture.completedFuture("OK");
	}

	public void doLocalTxr(double amount, String fromAccNumber, String toAccNumber) {
		System.out.println("Local Txr");
	}

	private void possibleFailure() {
		if (new Random().nextFloat() < 0.5f)
			throw new RuntimeException("resource failure");
	}

	private void randomSleep() {
		try {
			TimeUnit.SECONDS.sleep(new Random().nextInt(4));
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
