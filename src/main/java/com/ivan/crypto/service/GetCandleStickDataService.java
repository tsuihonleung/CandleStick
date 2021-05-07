package com.ivan.crypto.service;

import java.math.BigDecimal;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import com.ivan.crypto.dao.DataContainer;
import com.ivan.crypto.entity.CandleStick;
import com.ivan.crypto.service.bean.GetCandleStickDataServiceBean;

public class GetCandleStickDataService extends AbstractGetDataService {

	@SuppressWarnings("unused")
	private GetCandleStickDataService() {
		
	}
	
	public GetCandleStickDataService(GetCandleStickDataServiceBean bean) {
		apiUrl = bean.getApiUrl() + "public/get-candlestick?instrument_name=" + bean.getInstrumentName() + "&timeframe=" + bean.getTimeFrame();
	}
	
    public void getData() throws Exception {
    	
		//Connect and send request
    	connect();
    	
        //Using the JSON simple library parse the string into a json object
        JSONParser parse = new JSONParser();
        JSONObject obj = (JSONObject) parse.parse(inline);
    
        //Get the required object from the above created object
        long returnCode = (long) obj.get("code");

        if (returnCode == 0) {
	        //Get the required object from the above created object
	        JSONObject result_obj = (JSONObject) obj.get("result");
	        JSONArray arr = (JSONArray) result_obj.get("data");
	        
	        for (int i = 0; i < arr.size(); i++) {
	            JSONObject new_obj = (JSONObject) arr.get(i);
	            CandleStick candleStick = new CandleStick();
	            candleStick.setStartTime((Long) new_obj.get("t"));
	            candleStick.setOpen(BigDecimal.valueOf((Double) new_obj.get("o")));
	            candleStick.setHigh(BigDecimal.valueOf((Double) new_obj.get("h")));
	            candleStick.setLow(BigDecimal.valueOf((Double) new_obj.get("l")));
	            candleStick.setClose(BigDecimal.valueOf((Double) new_obj.get("c")));
	            candleStick.setVolume(BigDecimal.valueOf((Double)new_obj.get("v")));
	            DataContainer.getInstance().addCandleStick(candleStick);
	        }
        } else {
        	throw new Exception("Get data error. returnCode= " + returnCode);
        }

    }
    
}
