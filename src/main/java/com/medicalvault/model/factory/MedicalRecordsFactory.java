package com.medicalvault.model.factory;

import com.medicalvault.model.MedicalRecords;
import com.medicalvault.domain.MedicalRecordsEntity;

public class MedicalRecordsFactory {

  public static MedicalRecords create(MedicalRecordsEntity medicalRecordsEntity) {

    return new MedicalRecords(
        medicalRecordsEntity.getUser().getUsername(),
        String.valueOf(medicalRecordsEntity.getUser().getId()),
        medicalRecordsEntity.getHospital(),
        medicalRecordsEntity.getReferringHospital(),
        medicalRecordsEntity.getDoctor(),
        medicalRecordsEntity.getReferringDoctor(),
        medicalRecordsEntity.getProblems(),
        medicalRecordsEntity.getMedications(),
        medicalRecordsEntity.getAllergies(),
        medicalRecordsEntity.getMedicalHistory());
  }
}
