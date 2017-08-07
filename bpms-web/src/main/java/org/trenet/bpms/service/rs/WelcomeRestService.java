package org.trenet.bpms.service.rs;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Path("/welcome")
public interface WelcomeRestService {
	
	@GET
    @Path("/")
	public String welcome();
}
