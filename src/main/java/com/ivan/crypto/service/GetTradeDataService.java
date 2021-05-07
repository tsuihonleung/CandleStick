package com.ivan.crypto.service;

import java.math.BigDecimal;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import com.ivan.crypto.dao.DataContainer;
import com.ivan.crypto.entity.Trade;
import com.ivan.crypto.service.bean.GetTradeDataServiceBean;

public class GetTradeDataService extends AbstractGetDataService {

	@SuppressWarnings("unused")
	private GetTradeDataService() {
		
	}
	
	public GetTradeDataService(GetTradeDataServiceBean bean) {
		apiUrl = bean.getApiUrl() + "public/get-trades?instrument_name=" + bean.getInstrumentName();
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
	            Trade trade = new Trade();
	            trade.setTradePrice(BigDecimal.valueOf((Double) new_obj.get("p")));
	            trade.setTradeQty(BigDecimal.valueOf((Double)new_obj.get("q")));
	            trade.setSide((String) new_obj.get("s"));
	            trade.setTradeId((Long) new_obj.get("d"));
	            trade.setTradeTimestamp((Long) new_obj.get("t"));
	            DataContainer.getInstance().addTrade(trade);
	        }
        } else {
        	throw new Exception("Get data error. returnCode= " + returnCode);
        }

    }
    
}
