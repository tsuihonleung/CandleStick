package com.ivan.crypto;

import com.ivan.crypto.bean.AppBean;
import com.ivan.crypto.enumeration.TimeFrame;
import com.ivan.crypto.service.VerifyCandleStickService;
import com.ivan.crypto.service.GetCandleStickDataService;
import com.ivan.crypto.service.GetTradeDataService;
import com.ivan.crypto.service.bean.VerifyCandleStickServiceBean;
import com.ivan.crypto.service.bean.GetCandleStickDataServiceBean;
import com.ivan.crypto.service.bean.GetTradeDataServiceBean;

public class App {

	public static final String UAT_SANDBOX_URL = "https://uat-api.3ona.co/v2/";
	public static final String PRODUCTION_URL = "https://api.crypto.com/v2/";
	
    public static void main(String[] args) {

    	try {
    		// Config for this app
			AppBean appBean = new AppBean();
			appBean.setApiUrl(PRODUCTION_URL);
			appBean.setInstrumentName("BTC_USDT");
			appBean.setTimeFrame(TimeFrame.ONE_MIN.getTimeFrame());
			
			// Get CandleStick data
			GetCandleStickDataServiceBean cBean = new GetCandleStickDataServiceBean();
			cBean.setApiUrl(appBean.getApiUrl());
			cBean.setInstrumentName(appBean.getInstrumentName());
			cBean.setTimeFrame(appBean.getTimeFrame());
			GetCandleStickDataService cService = new GetCandleStickDataService(cBean);
			cService.getData();
			
			// Get Trade data
			GetTradeDataServiceBean tBean = new GetTradeDataServiceBean();
			tBean.setApiUrl(appBean.getApiUrl());
			tBean.setInstrumentName(appBean.getInstrumentName());
			GetTradeDataService tService = new GetTradeDataService(tBean);
			tService.getData();
			
			// Start verify the consistency of the candle sticks
			VerifyCandleStickServiceBean vBean = new VerifyCandleStickServiceBean();
			vBean.setTimeFrame(appBean.getTimeFrame());
			vBean.setInstrumentName(appBean.getInstrumentName());
			VerifyCandleStickService vService = new VerifyCandleStickService(vBean);
			vService.verify();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    }
    
}