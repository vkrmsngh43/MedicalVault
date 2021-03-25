package com.pe.medical.service;

import com.pe.medical.model.PrescriptionRecordsResponse;
import org.springframework.stereotype.Service;

@Service
public interface PrescriptionRecordsService {
  /**
   * Gets the prescription records for a given userId;
   *
   * @param userId
   * @return
   */
  public PrescriptionRecordsResponse getPrescriptionRecordsOfUser(String userId);
}
