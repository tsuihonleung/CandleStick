/**
 * 
 */
package com.ivan.crypto.dao;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.ivan.crypto.entity.Trade;

/**
 * @author 
 *
 */
class DataContainerTest {

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeAll
	static void setup() throws Exception {
		DataContainer.getInstance().addTrade(new Trade(1619335440000L, new BigDecimal("49722.58"), new BigDecimal("0.000252"), "BUY", 1392061151000000000L));
		DataContainer.getInstance().addTrade(new Trade(1619335440000L, new BigDecimal("49722.58"), new BigDecimal("0.000252"), "BUY", 1392061150000000000L));
		DataContainer.getInstance().addTrade(new Trade(1619335440000L, new BigDecimal("49722.58"), new BigDecimal("0.000252"), "BUY", 1392061152000000000L));
		DataContainer.getInstance().addTrade(new Trade(1619335450000L, new BigDecimal("49767.78"), new BigDecimal("0.003397"), "BUY", 1392061155000000000L));
		DataContainer.getInstance().addTrade(new Trade(1619335410000L, new BigDecimal("49674.33"), new BigDecimal("0.000120"), "BUY", 1392061156000000000L));
		DataContainer.getInstance().addTrade(new Trade(1619335420000L, new BigDecimal("49674.33"), new BigDecimal("0.000120"), "BUY", 1392061159000000000L));
	}

	@Test
	void testGetMinTradeTimestamp() {
		assertEquals(1619335410000L, DataContainer.getInstance().getMinTradeTimestamp());
	}

	@Test
	void testGetMaxTradeTimestamp() {
		assertEquals(1619335450000L, DataContainer.getInstance().getMaxTradeTimestamp());
	}

	@Test
	void testGetTradesInPeriod() {
		// test for sorting in timestamp
		assertEquals(1392061159000000000L, DataContainer.getInstance().getTradesInPeriod(1619335420000L, 1619335420000L).first().getTradeId());
		// test for sorting in timestamp and trade id
		assertEquals(1392061150000000000L, DataContainer.getInstance().getTradesInPeriod(1619335440000L, 1619335440000L).first().getTradeId());
	}

}
