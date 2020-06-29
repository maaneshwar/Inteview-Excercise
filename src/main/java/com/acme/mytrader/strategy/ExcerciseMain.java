package com.acme.mytrader.strategy;

public class ExcerciseMain {

	public static void main(String[] args) {
		TradingStrategy tradingStrategy= new TradingStrategy();
		
		StockMonitoring stockMonitoring1 = new StockMonitoring();
		stockMonitoring1.priceUpdate("stocks", 100, 100);
		
		StockMonitoring stockMonitoring2 = new StockMonitoring();
		stockMonitoring2.priceUpdate("bonds", 200, 50);
	}

}
