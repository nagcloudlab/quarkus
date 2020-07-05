package org.acme.quarkus.sample.service;

import javax.enterprise.context.ApplicationScoped;
import javax.json.bind.Jsonb;
import javax.json.bind.JsonbBuilder;

import org.acme.quarkus.sample.model.Txn;
import org.eclipse.microprofile.reactive.messaging.Incoming;
import org.eclipse.microprofile.reactive.messaging.Outgoing;

import io.smallrye.reactive.messaging.annotations.Broadcast;

@ApplicationScoped
public class TxnMonitorService {

	@Incoming("number-stream")
	@Outgoing("in-memory-stream")
	@Broadcast
	public int monitor(int number) {

		return number* 100;

	}

}
