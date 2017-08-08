package org.trenet.bpms.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.trenet.bpms.model.Item;

@Repository
public interface ItemDao extends JpaRepository<Item, Long> {}
