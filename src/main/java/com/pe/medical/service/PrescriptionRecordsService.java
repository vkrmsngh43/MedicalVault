package com.pe.medical.service;

import org.springframework.stereotype.Service;

import com.pe.medical.model.PrescriptionRecordsResponse;

@Service
public interface PrescriptionRecordsService {
	/**
	 * Gets the prescription records for a given userId;
	 * @param userId
	 * @return
	 */
	public PrescriptionRecordsResponse getPrescriptionRecordsOfUser(String userId);
}
