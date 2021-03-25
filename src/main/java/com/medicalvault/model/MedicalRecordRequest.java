package com.medicalvault.model;

public class MedicalRecordRequest extends BaseRequest {

  private String userId;
  private String username;

  public MedicalRecordRequest() {
    super();
  }

  public MedicalRecordRequest(String userId, String username) {
    super();
    this.userId = userId;
    this.username = username;
  }

  public String getUserId() {
    return userId;
  }

  public String getUsername() {
    return username;
  }
}
