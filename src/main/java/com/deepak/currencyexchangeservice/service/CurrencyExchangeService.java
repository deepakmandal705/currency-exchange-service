package com.deepak.currencyexchangeservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.deepak.currencyexchangeservice.bean.ExchangeValue;
import com.deepak.currencyexchangeservice.repositories.CurrencyExchangeRepository;

@Service
public class CurrencyExchangeService {

	@Autowired
	private CurrencyExchangeRepository exchangeRepository;
	
	public ExchangeValue saveCurrencyExchange(ExchangeValue exchangeValue) {
		exchangeValue = exchangeRepository.save(exchangeValue);
		return exchangeValue;
	}
	
	public ExchangeValue getCurrencyExchange(String from, String to) {
		ExchangeValue exchangeValue = exchangeRepository.findByFromAndTo(from, to);
		return exchangeValue;
	}
}
