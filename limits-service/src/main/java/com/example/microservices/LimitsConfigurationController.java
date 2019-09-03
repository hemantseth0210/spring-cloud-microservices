package com.example.microservices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@RestController
public class LimitsConfigurationController {
 
	@Autowired
	Configuration configuration;
	
	@GetMapping("/limits")
	public LimitConfiguration retrieveLimitsFromConfigurations() {
		return new LimitConfiguration(configuration.getMinimum(), configuration.getMaximum());
	}
	
	@GetMapping("/hystrix-example")
	@HystrixCommand(fallbackMethod = "fallbackRetrieveLimitsConfigurations")
	public LimitConfiguration retrieveLimitsConfigurations() {
		throw new RuntimeException("Not Available");
	}
	
	public LimitConfiguration fallbackRetrieveLimitsConfigurations() {
		return new LimitConfiguration(9, 999);
	}
}
