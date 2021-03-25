package com.pe.medical.service;

import org.springframework.stereotype.Service;

@Service
public interface AccessRequestService {

  public boolean placeAccessRequest(String userId) throws Exception;

  public boolean verifyAccessCode(String userId, String requesterId, String accessCode);
}
