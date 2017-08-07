package org.trenet.bpms.service.ws.impl;

import javax.jws.WebService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;
import org.trenet.bpms.Item;
import org.trenet.bpms.service.internal.WelcomeService;
import org.trenet.bpms.service.ws.WelcomeWebService;

@WebService(endpointInterface = "org.trenet.bpms.service.ws.WelcomeWebService")
public class WelcomeWebServiceImpl extends SpringBeanAutowiringSupport implements WelcomeWebService {

	@Autowired
	private WelcomeService welcomeService;
	
	@Override
	public Item welcome() {
		return welcomeService.welcome();
	}

}
