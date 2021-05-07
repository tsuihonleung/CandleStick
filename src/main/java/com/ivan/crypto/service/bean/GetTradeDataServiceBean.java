package com.ivan.crypto.service.bean;

public class GetTradeDataServiceBean {

	private String apiUrl = "";
	private String instrumentName = "";
	
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
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("GetTradeDataServiceBean [apiUrl=");
		builder.append(apiUrl);
		builder.append(", instrumentName=");
		builder.append(instrumentName);
		builder.append("]");
		return builder.toString();
	}
	
}
