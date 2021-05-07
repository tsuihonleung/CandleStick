package com.ivan.crypto.enumeration;

public enum TimeFrame {

	ONE_MIN ("1m", "one minute", 60000),
	FIVE_MIN ("5m", "5 minutes", 300000),
	FIFTEEN_MIN ("15m", "15 minutes", 900000),
	THIRTY_MIN ("30m", "30 minutes", 1800000),
	ONE_HR ("1h", "one hour", 3600000),
	FOUR_HR ("4h", "4 hours", 14400000),
	SIX_HR ("6h", "6 hours", 21600000),
	TWELVE_HR ("12h", "12 hours", 43200000),
	ONE_DAY ("1D", "one day", 86400000),
	SEVEN_DAY ("7D", "one week", 604800000),
	FOURTEEN_DAY ("14D", "two weeks", 1209600000),
	ONE_MONTH ("1M", "one month", -1);	// millisecond is undefined
	
	private final String timeFrame;
	private final String description;
	private final long millisecond;
	
	TimeFrame(String timeFrame, String description, long millisecond) {
		this.timeFrame = timeFrame;
		this.description = description;
		this.millisecond = millisecond;
	}

	public String getTimeFrame() {
		return timeFrame;
	}

	public String getDescription() {
		return description;
	}

	public long getMillisecond() {
		return millisecond;
	}

}
