package com.deepak.currencyexchangeservice.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.deepak.currencyexchangeservice.bean.ExchangeValue;
import com.deepak.currencyexchangeservice.service.CurrencyExchangeService;

@RestController
public class CurrencyExchangeController {

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private Environment environment;
	
	@Autowired
	private CurrencyExchangeService exchangeService;
	
	@PostMapping(value = "currency-exchange-jpa")
	public ExchangeValue saveCurrencyExchangeValue(@RequestBody ExchangeValue exchangeValue) {
		exchangeValue = exchangeService.saveCurrencyExchange(exchangeValue);
		exchangeValue.setPort(Integer.parseInt(
				environment.getProperty("local.server.port")));
		
		return exchangeValue;
	}
	
	@GetMapping(value = "currency-exchange-jpa/from/{from}/to/{to}")
	public ExchangeValue getCurrencyExchangeValueFromJpa(@PathVariable String from,
			@PathVariable String to) {
		ExchangeValue exchangeValue = exchangeService.getCurrencyExchange(from, to);
		exchangeValue.setPort(Integer.parseInt(
				environment.getProperty("local.server.port")));
		
		logger.info("{}", exchangeValue);
		
		return exchangeValue;
	}
}
