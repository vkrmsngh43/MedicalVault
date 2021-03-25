package com.medicalvault.service.impl;

import com.medicalvault.domain.MedicalRecordsEntity;
import com.medicalvault.model.MedicalRecords;
import com.medicalvault.model.MedicalRecordsResponse;
import com.medicalvault.model.factory.MedicalRecordsFactory;
import com.medicalvault.repository.MedicalRecordsRepository;
import com.medicalvault.service.MedicalRecordsService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class MedicalRecordsServiceImpl implements MedicalRecordsService {

  @Autowired MedicalRecordsRepository medicalRecordsRepository;

  @Override
  public Optional<MedicalRecordsEntity> getMedicalRecordById(Long id) {
    return medicalRecordsRepository.findById(id);
  }

  @Override
  public MedicalRecordsResponse getMedicalRecordsByUserId(Long userId) {
    MedicalRecordsResponse medicalRecordsResponse = new MedicalRecordsResponse();
    try {
      List<MedicalRecordsEntity> medicalRecords =
          medicalRecordsRepository.findAllMedicalRecordeForUserId(userId);
      if (medicalRecords != null) {
        List<MedicalRecords> medicalRecordsModel = new ArrayList<>();

        for (MedicalRecordsEntity medicalRecordsEntity : medicalRecords) {
          medicalRecordsModel.add(MedicalRecordsFactory.create(medicalRecordsEntity));
        }
        medicalRecordsResponse.setMedicalRecords(medicalRecordsModel);
      }
    } catch (Exception ex) {
      log.error("An error while fetching medical records. Error {}", ex.getMessage());
      ex.printStackTrace();
    }
    return medicalRecordsResponse;
  }
}
