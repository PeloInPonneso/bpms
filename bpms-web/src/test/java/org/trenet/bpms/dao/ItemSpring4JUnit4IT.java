package org.trenet.bpms.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;
import org.trenet.bpms.config.PersistanceConfig;
import org.trenet.bpms.config.SpringRootConfig;
import org.trenet.bpms.model.Item;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {SpringRootConfig.class, PersistanceConfig.class})
public class ItemSpring4JUnit4IT {
	
	@Autowired
	private ItemDao itemDao;

	@Test
	@Transactional
    @Rollback(true)
	public void itemTest() {
		Item item = itemDao.save(new Item(1l, "TEST", "This is a Test Item"));
		Assert.notNull(item);
		Assert.isTrue(item.getCode().equals("TEST"));
		item = itemDao.findOne(1l);
		Assert.notNull(item);
		Assert.isTrue(item.getId().longValue() == 1);
		item.setDescription("Test UPDATE");
		item = itemDao.save(item);
		Assert.notNull(item);
		Assert.isTrue(item.getDescription().equals("Test UPDATE"));
		itemDao.delete(item);
		item = itemDao.findOne(1l);
		Assert.isNull(item);
	}
}
