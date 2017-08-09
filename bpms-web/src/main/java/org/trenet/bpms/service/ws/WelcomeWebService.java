package org.trenet.bpms.service.ws;

import java.util.List;

import javax.jws.WebService;

import org.trenet.bpms.model.Item;

@WebService
public interface WelcomeWebService {

	public List<Item> welcome();
}
