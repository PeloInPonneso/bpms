package org.trenet.bpms.service.rs.impl;

import java.util.List;

import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.trenet.bpms.model.Item;
import org.trenet.bpms.service.internal.WelcomeService;
import org.trenet.bpms.service.rs.WelcomeRestService;

@Component
public class WelcomeRestServiceImpl implements WelcomeRestService {

	@Autowired
	private WelcomeService welcomeService;
	
	@Override
	public Response welcome() {
		GenericEntity<List<Item>> items = new GenericEntity<List<Item>>(welcomeService.findAllItems()){};
		return Response.status(Status.OK).entity(items).build();
	}

}
