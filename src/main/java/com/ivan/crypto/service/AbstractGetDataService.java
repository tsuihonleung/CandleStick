package com.ivan.crypto.service;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.Scanner;

public abstract class AbstractGetDataService {

	protected String apiUrl = "";
	protected String inline = "";

	protected void connect() throws Exception {

        try {
			URL url = new URL(apiUrl);

			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("GET");
			conn.connect();

			//Getting the response code
			int responseCode = conn.getResponseCode();
			
			if (responseCode != 200) {
			    throw new RuntimeException("HttpResponseCode: " + responseCode);
			} else {
			    Scanner scanner = new Scanner(url.openStream());

			    //Write all the JSON data into a string using a scanner
			    while (scanner.hasNext()) {
			        inline += scanner.nextLine();
			    }

			    //Close the scanner
			    scanner.close();
			    
			}
		} catch (MalformedURLException e) {
			throw new Exception("MalformedURL=" + apiUrl);
		} catch (ProtocolException e) {
			throw new Exception("Bad protocol");
		} catch (IOException e) {
			throw new Exception(e);
		}
	};
	
}
