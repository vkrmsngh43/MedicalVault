package com.pe.medical.model;

public class MedicalRecords {

  private String username;

  private String userId;

  private String hospital;

  private String referringHospital;

  private String doctor;

  private String referringDoctor;

  private String problems;

  private String medications;

  private String allergies;

  private String medicalHistory;

  public MedicalRecords(
      String username,
      String userId,
      String hospital,
      String referringHospital,
      String doctor,
      String referringDoctor,
      String problems,
      String medications,
      String allergies,
      String medicalHistory) {
    super();
    this.username = username;
    this.userId = userId;
    this.hospital = hospital;
    this.referringHospital = referringHospital;
    this.doctor = doctor;
    this.referringDoctor = referringDoctor;
    this.problems = problems;
    this.medications = medications;
    this.allergies = allergies;
    this.medicalHistory = medicalHistory;
  }

  public String getUsername() {
    return username;
  }

  public String getUserId() {
    return userId;
  }

  public String getHospital() {
    return hospital;
  }

  public String getReferringHospital() {
    return referringHospital;
  }

  public String getDoctor() {
    return doctor;
  }

  public String getReferringDoctor() {
    return referringDoctor;
  }

  public String getProblems() {
    return problems;
  }

  public String getMedications() {
    return medications;
  }

  public String getAllergies() {
    return allergies;
  }

  public String getMedicalHistory() {
    return medicalHistory;
  }
}
