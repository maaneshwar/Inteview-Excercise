package com.acme.mytrader.strategy;

import java.util.ArrayList;
import java.util.List;

import com.acme.mytrader.execution.ExecutionService;
import com.acme.mytrader.price.PriceListener;
import com.acme.mytrader.price.PriceSource;

/**
 * <pre>
 * User Story: As a trader I want to be able to monitor stock prices such
 * that when they breach a trigger level orders can be executed automatically
 * </pre>
 */
public class TradingStrategy implements ExecutionService, PriceSource {

	private ArrayList<PriceListener> priceListeners;

	private String security;
	private double price;
	private int volume;

	double max = 0;

	List<Double> priceList = new ArrayList<>();

	public TradingStrategy() {

		priceListeners = new ArrayList<>();
	}

	public void notifyPriceListener() {
		for (PriceListener priceListener : priceListeners) {
			priceListener.priceUpdate(security, price, volume);
		}
	}

	@Override
	public void buy(String security, double price, int volume) {
		priceList.add(price);
		notifyPriceListener();
	}

	@Override
	public void sell(String security, double price, int volume) {
		priceList.remove(price);
		notifyPriceListener();
	}

	@Override
	public void addPriceListener(PriceListener listener) {
		buy(security, price, volume);
		notifyPriceListener();
	}

	@Override
	public void removePriceListener(PriceListener listener) {
		calcMaxPrft(priceList);
		if (max > 0) {
			sell(security, price, volume);
			notifyPriceListener();
		}
	}

	private Double calcMaxPrft(List<Double> prices) {
		max = 0;
		double lowprice = prices.get(0);
		for (Double price : prices) {
			double profit = 0;
			if (price > lowprice) {
				profit = price - lowprice;
				if (profit > max) {
					max = profit;
				}
			} else {
				lowprice = price;
			}
		}
		return max;
	}

}
