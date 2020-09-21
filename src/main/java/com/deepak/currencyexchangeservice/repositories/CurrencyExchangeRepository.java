package com.deepak.currencyexchangeservice.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.deepak.currencyexchangeservice.bean.ExchangeValue;

@Repository
public interface CurrencyExchangeRepository extends JpaRepository<ExchangeValue, Integer>{

	public ExchangeValue findByFromAndTo(String from, String to);
}
