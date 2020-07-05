package org.acme.quarkus.sample.web;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

import org.acme.quarkus.sample.service.TokenGenerator;

@Path("/token")
public class TokenEndpoint {

	@Inject
	TokenGenerator tokenGenerator;

	@GET
	public String getToken() {
		return tokenGenerator.getToken();
	}

}
