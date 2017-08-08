package org.trenet.bpms.service.internal.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.trenet.bpms.dao.ItemDao;
import org.trenet.bpms.model.Item;
import org.trenet.bpms.service.internal.WelcomeService;

@Service
public class WelcomeServiceImpl implements WelcomeService {
	
	@Autowired
	private ItemDao itemDao;
	
	@Override
	public Item welcome() {
		Item item = itemDao.save(new Item(1l, "TEST", "This is a Test Item"));
		return item;
	}

}
