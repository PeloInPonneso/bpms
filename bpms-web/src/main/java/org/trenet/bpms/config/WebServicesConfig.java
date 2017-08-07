package org.trenet.bpms.config;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.xml.ws.Endpoint;

import org.apache.cxf.Bus;
import org.apache.cxf.bus.spring.SpringBus;
import org.apache.cxf.endpoint.Server;
import org.apache.cxf.jaxrs.JAXRSServerFactoryBean;
import org.apache.cxf.jaxrs.lifecycle.ResourceProvider;
import org.apache.cxf.jaxrs.spring.SpringResourceFactory;
import org.apache.cxf.jaxws.EndpointImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.trenet.bpms.service.ws.impl.WelcomeWebServiceImpl;

import com.fasterxml.jackson.jaxrs.json.JacksonJaxbJsonProvider;

/**
 * @author caballero
 * Equivalent of cxf-servlet.xml
 */
@Configuration
public class WebServicesConfig {
	
	private static final Logger logger = LoggerFactory.getLogger(WebServicesConfig.class);
	
	@Autowired
    private ApplicationContext ctx;
	
	@Bean(name = Bus.DEFAULT_BUS_ID)
	public SpringBus springBus() {
		SpringBus bus = new SpringBus();
		bus.setApplicationContext(ctx);
	    return bus;
	}
	
	@Bean
	public Endpoint welcome() {
	    EndpointImpl endpoint = new EndpointImpl(springBus(), ctx.getBean(WelcomeWebServiceImpl.class));
	    endpoint.publish(ctx.getEnvironment().getProperty("org.trenet.bpms.service.ws.welcome"));
	    return endpoint;
	}
	
	@Bean
    public Server jaxRsServer() {
		// Resource Providers
		List<ResourceProvider> resourceProviders = new LinkedList<ResourceProvider>();
		String[] wsServiceBeanList = ctx.getBeanNamesForAnnotation(Path.class);
		logger.info("Detected " + wsServiceBeanList.length + " Beans with Path Annotation");
		for (String wsServiceBean : wsServiceBeanList) {
			logger.info("Adding " + wsServiceBean + " to as ResourceProvider");
			SpringResourceFactory resource = new SpringResourceFactory(wsServiceBean);
			resource.setApplicationContext(ctx);
			resourceProviders.add(resource);
		}
		// Extension Mappings
		Map<Object, Object> extMaps = new HashMap<Object, Object>();
		extMaps.put("json", MediaType.APPLICATION_JSON);
		extMaps.put("xml", MediaType.APPLICATION_XML);
		// Providers
		List<Object> providers = new LinkedList<Object>();
		providers.add(new JacksonJaxbJsonProvider());
		// JAXRS Server
		JAXRSServerFactoryBean factory = new JAXRSServerFactoryBean();
		factory.setBus(springBus());
		factory.setResourceProviders(resourceProviders);
		factory.setProviders(providers);
		factory.setExtensionMappings(extMaps);
		factory.setAddress(ctx.getEnvironment().getProperty("org.trenet.bpms.service.rs.base"));
		return factory.create();
	}
}
