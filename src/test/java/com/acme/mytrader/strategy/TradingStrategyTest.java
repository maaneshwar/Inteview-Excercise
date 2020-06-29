package com.acme.mytrader.strategy;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import com.acme.mytrader.price.PriceListener;
import com.acme.mytrader.price.PriceSource;

@RunWith(MockitoJUnitRunner.class)
public class TradingStrategyTest {

	@InjectMocks
	private TradingStrategy tradingStrategy;

	@Mock
	private PriceListener priceListener;

	@Mock
	private PriceSource priceSource;

	@Before
	public void init() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void test() {
		List<Double> priceList = new ArrayList<>();
		when(tradingStrategy.max).thenReturn(new Double(0));
		assertEquals(tradingStrategy.priceList, priceList);
	}
}
