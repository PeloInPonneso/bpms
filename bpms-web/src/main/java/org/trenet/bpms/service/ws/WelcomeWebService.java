package org.trenet.bpms.service.ws;

import javax.jws.WebService;

import org.trenet.bpms.Item;

@WebService
public interface WelcomeWebService {

	public Item welcome();
}
