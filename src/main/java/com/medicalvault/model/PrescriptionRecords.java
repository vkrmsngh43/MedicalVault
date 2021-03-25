package com.pe.medical.model;

import java.util.Date;

public class PrescriptionRecords {

  private String userId;

  private String username;

  private String prescribedBy;

  private String medicalCondition;

  private String allergies;

  private int medicDuration;

  private String prescriptions;

  private String prescriptionNotes;

  private Date createdAt;

  public PrescriptionRecords(
      String userId,
      String username,
      String prescribedBy,
      String medicalCondition,
      String allergies,
      int medicDuration,
      String prescriptions,
      String prescriptionNotes,
      Date createdAt) {
    super();
    this.userId = userId;
    this.username = username;
    this.prescribedBy = prescribedBy;
    this.medicalCondition = medicalCondition;
    this.allergies = allergies;
    this.medicDuration = medicDuration;
    this.prescriptions = prescriptions;
    this.prescriptionNotes = prescriptionNotes;
    this.createdAt = createdAt;
  }

  public String getUserId() {
    return userId;
  }

  public String getUsername() {
    return username;
  }

  public String getPrescribedBy() {
    return prescribedBy;
  }

  public String getMedicalCondition() {
    return medicalCondition;
  }

  public String getAllergies() {
    return allergies;
  }

  public int getMedicDuration() {
    return medicDuration;
  }

  public String getPrescriptions() {
    return prescriptions;
  }

  public String getPrescriptionNotes() {
    return prescriptionNotes;
  }

  public Date getCreatedAt() {
    return createdAt;
  }
}
