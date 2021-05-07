package com.ivan.crypto.service.bean;

public class VerifyCandleStickServiceBean {

	private String timeFrame = "";
	private String instrumentName = "";
		
	public String getTimeFrame() {
		return timeFrame;
	}

	public void setTimeFrame(String timeFrame) {
		this.timeFrame = timeFrame;
	}

	public String getInstrumentName() {
		return instrumentName;
	}
	
	public void setInstrumentName(String instrumentName) {
		this.instrumentName = instrumentName;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("CandleStickVerifyServiceBean [timeFrame=");
		builder.append(timeFrame);
		builder.append(", instrumentName=");
		builder.append(instrumentName);
		builder.append("]");
		return builder.toString();
	}

	
}
