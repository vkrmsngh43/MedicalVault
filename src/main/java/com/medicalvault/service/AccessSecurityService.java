package com.medicalvault.service;

import org.springframework.stereotype.Service;

@Service
public interface AccessSecurityService {

  Boolean hasAccessToMedicalRecords();

  Boolean hasAccessToPrescriptionRecords();
}
