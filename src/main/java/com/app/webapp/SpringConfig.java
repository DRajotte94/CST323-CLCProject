package com.app.webapp;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.app.webapp.services.ProductBusinessService;
import com.app.webapp.services.ProductBusinessServiceInterface;

@Configuration
public class SpringConfig {
	
	@Bean(name="productBusinessService")
	public ProductBusinessServiceInterface getProductBusiness() {
		return new ProductBusinessService();
	}
	
}
