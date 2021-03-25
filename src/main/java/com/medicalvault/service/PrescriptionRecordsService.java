package com.medicalvault.service;

import com.medicalvault.model.PrescriptionRecordsResponse;
import org.springframework.stereotype.Service;

@Service
public interface PrescriptionRecordsService {
  /**
   * Gets the prescription records for a given userId;
   *
   * @param userId String
   * @return
   */
  PrescriptionRecordsResponse getPrescriptionRecordsOfUser(String userId);
}
