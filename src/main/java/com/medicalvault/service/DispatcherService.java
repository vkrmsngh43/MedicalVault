package com.pe.medical.service;

import com.pe.medical.clients.HttpClient;
import com.pe.medical.domain.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DispatcherService {

  private static Logger logger = LoggerFactory.getLogger(DispatcherService.class);
  @Autowired HttpClient httpClient;

  public void dispatchAccessCodeToUser(User user, User requester, String accessCode) {

    logger.info("Dsiaptching accessCode to the user.");
    httpClient.sendMessage(
        user.getPhoneNumber(), user.getFirstName(), requester.getFirstName(), accessCode);
  }
}
