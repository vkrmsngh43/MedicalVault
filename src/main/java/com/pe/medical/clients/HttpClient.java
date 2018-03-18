package com.pe.medical.clients;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

@Service
public class HttpClient {
	
	private static Logger logger = LoggerFactory.getLogger(HttpClient.class);
	
	@Value("${two.fa.api.endpoint}")
	private String clientURL;
	
	@Value("${two.fa.api.key}")
	private String apiKey;
	
	@Value("${two.fa.sender}")
	private String sender;
	
	@Value("${two.fa.template}")
	private String template;
	
	OkHttpClient client = new OkHttpClient();
	
	/**
	 * Uses 2FA APIs to send message to the user. These variables are dynamically replaced
	 * in the template created in 2FA account.
	 * @param toNumber
	 * @param var1
	 * @param var2
	 * @param var3
	 */
	public void sendMessage(String toNumber, String var1, String var2, String var3){
		
		StringBuilder sb = new StringBuilder();
		sb.append("to=").append(toNumber).append("&");
		sb.append("var1=").append(var1).append("&");
		sb.append("var2=").append(var2).append("&");
		sb.append("var3=").append(var3);
		String URL = prepareGetURL() + sb.toString();

		Request request = new Request.Builder().url(URL).build();

		try {
		    Response response = client.newCall(request).execute();
		    if(response.isSuccessful()) {
		    	logger.info("Message successfully sent." + response.body().string());
		    }else{
		    	logger.error("SMS wasn't sent to the user. " + response.body().string());
		    }
		} catch (IOException e) {
			logger.error("An exception occurred while sending message to the user. " + e.getMessage());
		    e.printStackTrace();
		}
	}
	private String prepareGetURL() {
		StringBuilder sb = new StringBuilder();
		sb.append(clientURL).append("&");
		sb.append("apikey=").append(apiKey).append("&");
		sb.append("from=").append(sender).append("&");
		sb.append("templatename=").append(template).append("&");
		
		return sb.toString();
	}
}
