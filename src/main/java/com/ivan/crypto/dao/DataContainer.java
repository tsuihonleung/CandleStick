package com.ivan.crypto.dao;

import java.util.Iterator;
import java.util.TreeSet;

import com.ivan.crypto.entity.CandleStick;
import com.ivan.crypto.entity.Trade;

public class DataContainer {

	private static DataContainer instance = new DataContainer();
	
	private TreeSet<CandleStick> candleSticks = new TreeSet<CandleStick>();	// in ascending order by endTime	
	private TreeSet<Trade> trades = new TreeSet<Trade>();	// in ascending order by timestamp
	
	// to avoid instantiation
	private DataContainer() {}
	
	public static DataContainer getInstance() {
		if (instance == null) {
			synchronized (DataContainer.class) {
				if (instance == null) {
					instance = new DataContainer();
				}
			}
		}
		return instance;
	}
	
	public boolean addCandleStick(CandleStick candleStick) {
		return candleSticks.add(candleStick);
	}
	
	public TreeSet<CandleStick> getCandleSticks() {
		return candleSticks;
	}
	
	public boolean addTrade(Trade trade) {
		return trades.add(trade);
	}
	
	public TreeSet<Trade> getTrades() {
		return trades;
	}
	
	public long getMinTradeTimestamp() {
		return trades.first().getTradeTimestamp();
	}
	
	public long getMaxTradeTimestamp() {
		return trades.last().getTradeTimestamp();
	}
	
	/**
	 * Get all trades done within a specific time period
	 * @param startTime
	 * @param endTime
	 * @return all trade object between startTime and endTime inclusively
	 */
	public TreeSet<Trade> getTradesInPeriod(long startTime, long endTime) {
		TreeSet<Trade> result = new TreeSet<Trade>();
		Iterator<Trade> iter = trades.iterator();
		while (iter.hasNext()) {
			Trade trade = iter.next();
			if (trade.getTradeTimestamp() >= startTime && trade.getTradeTimestamp() <= endTime) {
				result.add(trade);
			}
			if (trade.getTradeTimestamp() > endTime) {
				// stop looping as the remaining trades are out of the time period
				break;
			}
		}
		return result;
	}
}
