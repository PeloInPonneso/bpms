package org.trenet.bpms.web;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.trenet.bpms.service.internal.WelcomeService;

@Controller
public class WelcomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(WelcomeController.class);
	
	@Autowired
	private WelcomeService welcomeService;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String index() {	
		return "index";
	}
	
}
