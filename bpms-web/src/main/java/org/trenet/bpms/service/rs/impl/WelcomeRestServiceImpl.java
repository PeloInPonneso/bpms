package org.trenet.bpms.service.rs.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.trenet.bpms.service.internal.WelcomeService;
import org.trenet.bpms.service.rs.WelcomeRestService;

@Component
public class WelcomeRestServiceImpl implements WelcomeRestService {

	@Autowired
	private WelcomeService welcomeService;
	
	@Override
	public String welcome() {
		return welcomeService.welcome();
	}

}
