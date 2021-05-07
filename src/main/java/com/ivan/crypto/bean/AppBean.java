package com.ivan.crypto.bean;

public class AppBean {

	private String apiUrl = "https://api.crypto.com/v2/";
	private String instrumentName = "BTC_USDT";
	private String timeFrame = "1m";
	
	public String getApiUrl() {
		return apiUrl;
	}
	public void setApiUrl(String apiUrl) {
		this.apiUrl = apiUrl;
	}
		
	public String getInstrumentName() {
		return instrumentName;
	}
	public void setInstrumentName(String instrumentName) {
		this.instrumentName = instrumentName;
	}
	
	public String getTimeFrame() {
		return timeFrame;
	}
	public void setTimeFrame(String timeFrame) {
		this.timeFrame = timeFrame;
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("AppBean [apiUrl=");
		builder.append(apiUrl);
		builder.append(", instrumentName=");
		builder.append(instrumentName);
		builder.append(", timeFrame=");
		builder.append(timeFrame);
		builder.append("]");
		return builder.toString();
	}
	
}
