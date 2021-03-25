package com.pe.medical.model.factory;

import com.pe.medical.domain.MedicalRecordsEntity;
import com.pe.medical.model.MedicalRecords;

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
