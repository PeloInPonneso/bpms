package org.trenet.bpms.service.rs;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

@Path("/welcome")
public interface WelcomeRestService {
	
	@GET
    @Path("/")
	public Response welcome();
}
