package com.ivan.crypto.entity;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.math.BigDecimal;

import org.junit.jupiter.api.Test;

public class CandleStickTest {
	
	private static CandleStick candleStick = new CandleStick();
	
    @Test
    public void addVolumeTest()
    {
    	candleStick.addVolume(new BigDecimal("1.1"));
    	candleStick.addVolume(new BigDecimal("1.2"));
        assertTrue(candleStick.getVolume().compareTo(new BigDecimal("2.30000")) == 0);
    }
}
