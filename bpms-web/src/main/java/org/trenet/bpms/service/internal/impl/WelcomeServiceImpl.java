package org.trenet.bpms.service.internal.impl;

import java.util.List;

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
	public List<Item> findAllItems() {
		return itemDao.findAll();
	}

}
