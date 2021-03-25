package com.pe.medical.service;

import com.pe.medical.domain.MedicalRecordsEntity;
import com.pe.medical.model.MedicalRecordsResponse;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public interface MedicalRecordsService {

  public Optional<MedicalRecordsEntity> getMedicalRecordById(Long id);

  public MedicalRecordsResponse getMedicalRecordsByUserId(Long userId);
}
