package com.pe.medical.model.factory;

import com.pe.medical.domain.PrescriptionRecordsEntity;
import com.pe.medical.model.PrescriptionRecords;

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
