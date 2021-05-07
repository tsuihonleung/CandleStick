package com.ivan.crypto.service;

import java.math.BigDecimal;
import java.util.Iterator;
import java.util.Set;

import com.ivan.crypto.dao.DataContainer;
import com.ivan.crypto.entity.CandleStick;
import com.ivan.crypto.entity.Trade;
import com.ivan.crypto.service.bean.VerifyCandleStickServiceBean;
import com.ivan.crypto.util.TimeUtil;

public class VerifyCandleStickService {

	private String timeFrame;
	
	public VerifyCandleStickService() {
		
	}
	
	public VerifyCandleStickService(VerifyCandleStickServiceBean bean) {
		this.timeFrame = bean.getTimeFrame();
	}
	
	public void verify() {
		short matchCount = 0, unmatchCount = 0;
		//For each candle stick period, calculate the candle stick from the trades
		Iterator<CandleStick> iter = DataContainer.getInstance().getCandleSticks().iterator();
		while (iter.hasNext()) {
			CandleStick candleStick = iter.next();
			CandleStick calculatedCandleStick = getCandleStickFromTrades(candleStick.getStartTime());
			if (calculatedCandleStick == null) {
				System.out.println("Incomplete trades. Skip process for ." + candleStick);
			} else {
				System.out.println("candleStick          ="+candleStick);
				System.out.println("calculatedCandleStick="+calculatedCandleStick);
				if (candleStick.equals(calculatedCandleStick)) {
					System.out.println("*** Result matched ***");
					matchCount++;
				} else {
					System.out.println("*** Result NOT matched ***");
					unmatchCount++;
				}
			}
			System.out.println("========================");
		}
		System.out.println("Total trades:" + DataContainer.getInstance().getTrades().size());
		System.out.println("Total candlesticks:" + DataContainer.getInstance().getCandleSticks().size());
		System.out.println("Match count:" + matchCount);
		System.out.println("Unmatch count:" + unmatchCount);
	}
    
	private CandleStick getCandleStickFromTrades(long startTime) {
		CandleStick candleStick = null;
		Trade trade = null;
		long endTime = TimeUtil.getEndTime(startTime, this.timeFrame);
		
		// check if all trades in the period can be obtained
		// if the start time is smaller than minimum available trade timestamp, there may have some earlier trades are missing
		// if the end time is larger than maximum available trade timestamp, there may have some older trades are missing
		if (startTime < DataContainer.getInstance().getMinTradeTimestamp()
				|| endTime > DataContainer.getInstance().getMaxTradeTimestamp()
				) {
			System.out.println("Incomplete trades available between " + startTime + " and " + endTime);
		} else {
			// get all trades within the specific period
			Set<Trade> trades = DataContainer.getInstance().getTradesInPeriod(startTime, endTime);
			// construct the candle stick
			Iterator<Trade> iter = trades.iterator();
			while (iter.hasNext()) {
				trade = iter.next();
				if (candleStick == null) {
					// for the first trade record, open price is set here
					candleStick = new CandleStick(startTime, trade.getTradePrice(), trade.getTradePrice(), 
							trade.getTradePrice(), trade.getTradePrice(), BigDecimal.ZERO);
					System.out.println("first trade of the period:" + trade);
				}
				// deduce high price
				if (trade.getTradePrice().compareTo(candleStick.getHigh()) > 0) {
					candleStick.setHigh(trade.getTradePrice());
				}
				// deduce low price
				if (trade.getTradePrice().compareTo(candleStick.getLow()) < 0) {
					candleStick.setLow(trade.getTradePrice());
				}
				// accumulate volume
				candleStick.addVolume(trade.getTradeQty());
			}
			if (trade != null) {
				// the last trade is the close price of the period
				candleStick.setClose(trade.getTradePrice());
				System.out.println("last trade of the period:" + trade);
			}
		}
		return candleStick;
	}
	
}
