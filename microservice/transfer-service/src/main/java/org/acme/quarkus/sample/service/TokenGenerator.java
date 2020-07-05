package org.acme.quarkus.sample.service;

import java.util.UUID;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;

import io.quarkus.scheduler.Scheduled;

@ApplicationScoped
public class TokenGenerator {

	private String token;

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	@Scheduled(every = "10s")
	void generateToken() {
		token = UUID.randomUUID().toString();
	}

	@PostConstruct
	public void init() {
		//
	}

}
