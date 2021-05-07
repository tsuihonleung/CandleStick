package com.ivan.crypto.util;

import java.util.Calendar;

import com.ivan.crypto.enumeration.TimeFrame;

public class TimeUtil {

	public static long getEndTime(long startTime, String timeFrame) {
		long endTime = 0;
		switch (timeFrame)
		{
		case "1m":
			endTime = startTime + TimeFrame.ONE_MIN.getMillisecond() - 1;
			break;
		case "5m":
			endTime = startTime + TimeFrame.FIVE_MIN.getMillisecond() - 1;
			break;
		case "15m":
			endTime = startTime + TimeFrame.FIFTEEN_MIN.getMillisecond() - 1;
			break;
		case "30m":
			endTime = startTime + TimeFrame.THIRTY_MIN.getMillisecond() - 1;
			break;
		case "1h":
			endTime = startTime + TimeFrame.ONE_HR.getMillisecond() - 1;
			break;
		case "4h":
			endTime = startTime + TimeFrame.FOUR_HR.getMillisecond() - 1;
			break;
		case "6h":
			endTime = startTime + TimeFrame.SIX_HR.getMillisecond() - 1;
			break;
		case "12h":
			endTime = startTime + TimeFrame.TWELVE_HR.getMillisecond() - 1;
			break;
		case "1D":
			endTime = startTime + TimeFrame.ONE_DAY.getMillisecond() - 1;
			break;
		case "7D":
			endTime = startTime + TimeFrame.SEVEN_DAY.getMillisecond() - 1;
			break;
		case "14D":
			endTime = startTime + TimeFrame.FOURTEEN_DAY.getMillisecond() - 1;
			break;
		case "1M":
			Calendar calendar = Calendar.getInstance();
			calendar.setTimeInMillis(startTime);
			calendar.add(Calendar.MONTH, 1);
			endTime = calendar.getTime().getTime() - 1;
			break;
		default :
			return 0;
		}
		//System.out.println("timeUtil:" + endTime + "-" + startTime);
		return endTime;
	}
	
}
