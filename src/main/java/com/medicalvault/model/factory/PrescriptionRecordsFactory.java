package com.medicalvault.model.factory;

import com.medicalvault.model.PrescriptionRecords;
import com.medicalvault.domain.PrescriptionRecordsEntity;

public class PrescriptionRecordsFactory {

  public static PrescriptionRecords create(PrescriptionRecordsEntity prescriptionRecordsEntity) {
    return new PrescriptionRecords(
        String.valueOf(prescriptionRecordsEntity.getUser().getId()),
        prescriptionRecordsEntity.getUser().getUsername(),
        prescriptionRecordsEntity.getPrescribedBy().getUsername(),
        prescriptionRecordsEntity.getMedicalCondition(),
        prescriptionRecordsEntity.getAllergies(),
        prescriptionRecordsEntity.getMedicDuration(),
        prescriptionRecordsEntity.getPrescription(),
        prescriptionRecordsEntity.getPrescriptionNotes(),
        prescriptionRecordsEntity.getCreatedDate());
  }
}
