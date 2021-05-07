package com.ivan.crypto.service.bean;

public class GetCandleStickDataServiceBean {

	private String apiUrl = "";
	private String instrumentName = "";
	private String timeFrame = "";
	
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
		builder.append("GetCandleStickDataServiceBean [apiUrl=");
		builder.append(apiUrl);
		builder.append(", instrumentName=");
		builder.append(instrumentName);
		builder.append(", timeFrame=");
		builder.append(timeFrame);
		builder.append("]");
		return builder.toString();
	}
		
}
