package com.medicalvault.security;

/** @author vikramsingh */
public class SecurityConstants {

  public static final String JWT_SECRET = "SecretKeyToGenJWTs";
  public static final long TOKEN_EXPIRATION_TIME = 864_000_000; // 10 days
  public static final String JWT_TOKEN_PREFIX = "Bearer ";
  public static final String JWT_HEADER_STRING = "Authorization";
  public static final String SIGN_UP_URL = "/signup";
}
