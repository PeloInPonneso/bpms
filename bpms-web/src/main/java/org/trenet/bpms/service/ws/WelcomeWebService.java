package org.trenet.bpms.service.ws;

import javax.jws.WebService;

import org.trenet.bpms.model.Item;

@WebService
public interface WelcomeWebService {

	public Item welcome();
}
