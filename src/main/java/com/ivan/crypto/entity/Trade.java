package com.ivan.crypto.entity;

import java.math.BigDecimal;

public class Trade implements Comparable<Trade> {

	private long tradeTimestamp;
	private BigDecimal tradePrice;
	private BigDecimal tradeQty;
	private String side;
	private long tradeId;
	
	public Trade() {
		this.tradeTimestamp = -1;
		this.tradePrice = BigDecimal.ZERO;
		this.tradeQty = BigDecimal.ZERO;
		this.side = "";
		this.tradeId = -1;
	}

	public Trade(long tradeTimestamp, BigDecimal tradePrice, BigDecimal tradeQty, String side, long tradeId) {
		this.tradeTimestamp = tradeTimestamp;
		this.tradePrice = tradePrice;
		this.tradeQty = tradeQty;
		this.side = side;
		this.tradeId = tradeId;
	}
	
	public long getTradeTimestamp() {
		return tradeTimestamp;
	}
	public void setTradeTimestamp(long tradeTimestamp) {
		this.tradeTimestamp = tradeTimestamp;
	}
	public BigDecimal getTradePrice() {
		return tradePrice;
	}
	public void setTradePrice(BigDecimal tradePrice) {
		this.tradePrice = tradePrice;
	}
	public BigDecimal getTradeQty() {
		return tradeQty;
	}
	public void setTradeQty(BigDecimal tradeQty) {
		this.tradeQty = tradeQty;
	}
	public String getSide() {
		return side;
	}
	public void setSide(String side) {
		this.side = side;
	}
	public long getTradeId() {
		return tradeId;
	}
	public void setTradeId(long tradeId) {
		this.tradeId = tradeId;
	}
		
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Trade [tradeTimestamp=");
		builder.append(tradeTimestamp);
		builder.append(", tradePrice=");
		builder.append(tradePrice);
		builder.append(", tradeQty=");
		builder.append(tradeQty);
		builder.append(", side=");
		builder.append(side);
		builder.append(", tradeId=");
		builder.append(tradeId);
		builder.append("]");
		return builder.toString();
	}
	
	@Override
	public int compareTo(Trade o) {	// to sort in ascending order
		if (tradeTimestamp > o.getTradeTimestamp()) {
			return 1;
		} else if (tradeTimestamp < o.getTradeTimestamp()) {
			return -1;
		} else if (tradeTimestamp == o.getTradeTimestamp()) {
			if (tradeId > o.getTradeId()) {
				return 1;
			} else if (tradeId < o.getTradeId()) {
				return -1;
			}
		} 
		return 0;
	}
	
}
