package com.pe.medical.clients;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

@Service
public class HttpClient {
	
	private static Logger logger = LoggerFactory.getLogger(HttpClient.class);
	@Value("${two.fa.api.endpoint}")
	private String clientURL;
	
	@Value("${two.fa.api.key}")
	private String apiKey;
	
	OkHttpClient client = new OkHttpClient();
	
	public void sendMessage(String toNumber, String messagePayload){
		RequestBody formBody = new FormBody.Builder()
		        .add("FROM", "TFCTOR")
		        .add("Msg", messagePayload)
		        .add("To", toNumber)
		        .build();
		Request request = new Request.Builder()
		        .url(clientURL + apiKey + "/ADDON_SERVICES/SEND/PSMS")
		        .post(formBody)
		        .build();

		try {
		    Response response = client.newCall(request).execute();
		    if(response.isSuccessful()) {
		    	logger.info("Message successfully sent." + response.body().string());
		    }else{
		    	logger.error("SMS wasn't sent to the user. " + response.body().string());
		    }
		} catch (IOException e) {
		    e.printStackTrace();
		}
	}
	
}
