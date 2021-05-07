package com.ivan.crypto.util;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class TimeUtilTest {

	private static SimpleDateFormat formatter;
	private static Date startTime = null;
	
	@BeforeAll
	public static void setup() throws Exception {
		formatter = new SimpleDateFormat("yyyyMMdd HH:mm:ss.SSS");
		startTime = formatter.parse("20210228 23:50:00.000");
	}
	
	@Test
	void testGetEndTime() {
		Date endTime = null;
		Calendar calendar = Calendar.getInstance();

		// Test for minute time frame
		calendar.setTimeInMillis(startTime.getTime());
		calendar.add(Calendar.MINUTE, 1);
		assertEquals(TimeUtil.getEndTime(startTime.getTime(), "1m"), calendar.getTime().getTime() - 1);
		
		calendar.setTimeInMillis(startTime.getTime());
		calendar.add(Calendar.MINUTE, 5);
		assertEquals(TimeUtil.getEndTime(startTime.getTime(), "5m"), calendar.getTime().getTime() - 1);
		
		calendar.setTimeInMillis(startTime.getTime());
		calendar.add(Calendar.MINUTE, 15);
		assertEquals(TimeUtil.getEndTime(startTime.getTime(), "15m"), calendar.getTime().getTime() - 1);
		
		calendar.setTimeInMillis(startTime.getTime());
		calendar.add(Calendar.MINUTE, 30);
		assertEquals(TimeUtil.getEndTime(startTime.getTime(), "30m"), calendar.getTime().getTime() - 1);
		
		// Test for hour time frame
		calendar.setTimeInMillis(startTime.getTime());
		calendar.add(Calendar.HOUR, 1);
		assertEquals(TimeUtil.getEndTime(startTime.getTime(), "1h"), calendar.getTime().getTime() - 1);

		calendar.setTimeInMillis(startTime.getTime());
		calendar.add(Calendar.HOUR, 4);
		assertEquals(TimeUtil.getEndTime(startTime.getTime(), "4h"), calendar.getTime().getTime() - 1);

		calendar.setTimeInMillis(startTime.getTime());
		calendar.add(Calendar.HOUR, 6);
		assertEquals(TimeUtil.getEndTime(startTime.getTime(), "6h"), calendar.getTime().getTime() - 1);

		calendar.setTimeInMillis(startTime.getTime());
		calendar.add(Calendar.HOUR, 12);
		assertEquals(TimeUtil.getEndTime(startTime.getTime(), "12h"), calendar.getTime().getTime() - 1);

		// Test for day time frame
		calendar.setTimeInMillis(startTime.getTime());
		calendar.add(Calendar.DATE, 1);
		assertEquals(TimeUtil.getEndTime(startTime.getTime(), "1D"), calendar.getTime().getTime() - 1);

		calendar.setTimeInMillis(startTime.getTime());
		calendar.add(Calendar.DATE, 7);
		assertEquals(TimeUtil.getEndTime(startTime.getTime(), "7D"), calendar.getTime().getTime() - 1);

		calendar.setTimeInMillis(startTime.getTime());
		calendar.add(Calendar.DATE, 14);
		assertEquals(TimeUtil.getEndTime(startTime.getTime(), "14D"), calendar.getTime().getTime() - 1);

		// Test for month time frame
		try {
			endTime = formatter.parse("20210328 23:49:59.999");
		} catch (ParseException e) {
			e.printStackTrace();
		}
		assertEquals(TimeUtil.getEndTime(startTime.getTime(), "1M"), endTime.getTime());
		
	}

}
