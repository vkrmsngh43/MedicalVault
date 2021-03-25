package com.medicalvault.model;

public class AuthenticationResponse extends BaseResponse {

  private String jwtToken;

  public AuthenticationResponse(String jwtToken, int status, String message) {
    this.jwtToken = jwtToken;
    this.setMessage(message);
    this.setStatusCode(status);
  }

  public String getJwtToken() {
    return jwtToken;
  }

  public void setJwtToken(String jwtToken) {
    this.jwtToken = jwtToken;
  }
}
