package org.trenet.bpms.service.internal.impl;

import org.springframework.stereotype.Service;
import org.trenet.bpms.Item;
import org.trenet.bpms.service.internal.WelcomeService;

@Service
public class WelcomeServiceImpl implements WelcomeService {
		
	@Override
	public Item welcome() {
		return new Item(1l, "TEST", "This is a Test Item");
	}

}
