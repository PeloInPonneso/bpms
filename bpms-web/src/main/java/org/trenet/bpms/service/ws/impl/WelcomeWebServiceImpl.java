package org.trenet.bpms.service.ws.impl;

import java.util.List;

import javax.jws.WebService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.trenet.bpms.model.Item;
import org.trenet.bpms.service.internal.WelcomeService;
import org.trenet.bpms.service.ws.WelcomeWebService;

@Component
@WebService(endpointInterface = "org.trenet.bpms.service.ws.WelcomeWebService")
public class WelcomeWebServiceImpl implements WelcomeWebService {
	
	@Autowired
	private WelcomeService welcomeService;
	
	@Override
	public List<Item> welcome() {
		return welcomeService.findAllItems();
	}

}
