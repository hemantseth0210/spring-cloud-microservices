package com.example.conversion;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class CurrencyConversionController {

	@Autowired
	CurrencyExchangeServiceProxy currencyExchangeServiceProxy;
	
	//Using RestTemplate
	@GetMapping("/currency-converter/{from}/to/{to}/quantity/{quantity}")
	public CurrencyConversion convertCurrency(@PathVariable String from, 
			@PathVariable String to, @PathVariable BigDecimal quantity) {
		
		//Feign Problem 1
		Map<String, String> uriVariables = new HashMap<>();
		uriVariables.put("from", from);
		uriVariables.put("to", to);
		
		ResponseEntity<CurrencyConversion> forEntity = new RestTemplate()
				.getForEntity("http://localhost:8000/currency-exchange/{from}/to/{to}", 
						CurrencyConversion.class, uriVariables);
		CurrencyConversion response = forEntity.getBody();
		
		return new CurrencyConversion(response.getId(), from, to, 
				response.getConversionMultiple(), quantity, 
				quantity.multiply(response.getConversionMultiple()), response.getPort());
	}
	
	@GetMapping("/currency-converter-feign/{from}/to/{to}/quantity/{quantity}")
	public CurrencyConversion convertCurrencyFeign(@PathVariable String from, 
			@PathVariable String to, @PathVariable BigDecimal quantity) {
		
		CurrencyConversion response = currencyExchangeServiceProxy.
				retrieveExchangeValue(from, to);
		
		return new CurrencyConversion(response.getId(), from, to, 
				response.getConversionMultiple(), quantity, 
				quantity.multiply(response.getConversionMultiple()), response.getPort());
	}
}
