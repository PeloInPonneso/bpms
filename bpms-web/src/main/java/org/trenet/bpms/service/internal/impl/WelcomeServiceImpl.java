package org.trenet.bpms.service.internal.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;
import org.trenet.bpms.service.internal.WelcomeService;

@Service
public class WelcomeServiceImpl implements WelcomeService {
	
	@Autowired
	private ApplicationContext applicationContext;
	
	@Override
	public String welcome() {
		return applicationContext.getApplicationName();
	}

}
