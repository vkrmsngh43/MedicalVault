package com.pe.medical.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pe.medical.clients.HttpClient;
import com.pe.medical.domain.User;

@Service
public class DispatcherService {
	
	private static Logger logger = LoggerFactory.getLogger(DispatcherService.class);
	@Autowired
	HttpClient httpClient;
	public void dispatchAccessCodeToUser(User user, User requester, String accessCode) {
		StringBuilder message = new StringBuilder();
		message.append("Hello ").append(user.getFirstName()).append("! ");
		message.append("Mr. " + requester.getFirstName() + " has requested your private records. ");
		message.append("To approve, please share TAC " + accessCode + " with him.");
		
		httpClient.sendMessage(user.getPhoneNumber(), message.toString());
	}
}
