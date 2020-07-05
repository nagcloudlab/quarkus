package org.acme.quarkus.sample.model;

import java.time.LocalDate;
import java.time.LocalTime;

public class Txn {

	private int id;
	private double amount;
	private String accountNum;
	private LocalDate date;
	private LocalTime time;

	public Txn(int id, double amount, String accountNum, LocalDate date, LocalTime time) {
		super();
		this.id = id;
		this.amount = amount;
		this.accountNum = accountNum;
		this.date = date;
		this.time = time;
	}

	public String getAccountNum() {
		return accountNum;
	}

	public void setAccountNum(String accountNum) {
		this.accountNum = accountNum;
	}

	public Txn() {
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public LocalTime getTime() {
		return time;
	}

	public void setTime(LocalTime time) {
		this.time = time;
	}

}
