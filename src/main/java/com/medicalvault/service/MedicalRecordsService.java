package com.medicalvault.service;

import com.medicalvault.domain.MedicalRecordsEntity;
import com.medicalvault.model.MedicalRecordsResponse;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public interface MedicalRecordsService {

  Optional<MedicalRecordsEntity> getMedicalRecordById(Long id);

  MedicalRecordsResponse getMedicalRecordsByUserId(Long userId);
}
