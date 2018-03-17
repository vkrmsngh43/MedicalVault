package com.pe.medical.service;

import org.springframework.stereotype.Service;

@Service
public interface AccessSecurityService {
	
	public Boolean hasAccessToMedicalRecords();
	
	public Boolean hasAccessToPrescriptionRecords();
	
}
