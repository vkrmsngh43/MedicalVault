package com.medicalvault.model;

import java.util.List;

public class PrescriptionRecordsResponse extends BaseResponse {

  private List<PrescriptionRecords> prescriptionRecords;

  public List<PrescriptionRecords> getPrescriptionRecords() {
    return prescriptionRecords;
  }

  public void setPrescriptionRecords(List<PrescriptionRecords> prescriptionRecords) {
    this.prescriptionRecords = prescriptionRecords;
  }
}
