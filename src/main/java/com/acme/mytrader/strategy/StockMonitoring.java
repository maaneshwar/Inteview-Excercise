package com.acme.mytrader.strategy;

import java.util.logging.Level;
import java.util.logging.Logger;

import com.acme.mytrader.price.PriceListener;

public class StockMonitoring implements PriceListener {
	Logger logger = Logger.getLogger(StockMonitoring.class.getName());

	private String security;
	private double price;
	private int volume;

	@Override
	public void priceUpdate(String security, double price, int volume) {
		this.security = security;
		this.price = price;
		this.volume = volume;

		logger.log(Level.INFO, "Stock Monitoring Update: {0}, {1}, {2}",
				new Object[] { this.security, this.price, this.volume });

	}

}
