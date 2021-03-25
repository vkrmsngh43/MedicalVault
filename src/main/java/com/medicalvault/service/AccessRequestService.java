package com.medicalvault.service;

import org.springframework.stereotype.Service;

@Service
public interface AccessRequestService {

  boolean placeAccessRequest(String userId) throws Exception;

   boolean verifyAccessCode(String userId, String requesterId, String accessCode);
}
