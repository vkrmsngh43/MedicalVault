package com.pe.medical.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.pe.medical.domain.MedicalRecordsEntity;
import com.pe.medical.model.MedicalRecordsResponse;

@Service
public interface MedicalRecordsService {
	
	public Optional<MedicalRecordsEntity> getMedicalRecordById(Long id);
	
	public MedicalRecordsResponse getMedicalRecordsByUserId(Long userId);

}
