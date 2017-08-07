package org.trenet.bpms.config;

import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * @author caballero
 * Equivalent of spring-core-config.xml
 */
@Configuration
@PropertySource( "classpath:application.properties" )
@ComponentScan({ "org.trenet.bpms.service.internal", "org.trenet.bpms.service.rs", "org.trenet.bpms.service.ws" })
public class SpringRootConfig {
	
	@Bean
	public static PropertyPlaceholderConfigurer propertyPlaceholderConfigurer() {
		return new PropertyPlaceholderConfigurer();
	}
}
