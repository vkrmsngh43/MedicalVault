package com.pe.medical.clients;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;

@Service
public class TwilioClient {
	
	private static Logger logger = LoggerFactory.getLogger(TwilioClient.class);
	 @Value("${twilio.account.sid}")
	 private String ACCOUNT_SID;
	 
	 @Value("${twilio.auth.token}")
	 private String AUTH_TOKEN;
	 
	 @Value("${twilio.sender.phone}")
	 private String from;
	 
	 @PostConstruct
	 public void init() {
		 Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
	 }
	 public void sendMessage(String toPhoneNumber, String messageBody) {
		 Message message = Message.creator(new PhoneNumber(toPhoneNumber),
				 new PhoneNumber(from), messageBody).
				 create();
		 logger.info("Message has been dispatched " + message.getSid() + "message :" + messageBody);
	 }
}
