package com.medicalvault.helper;

import org.springframework.stereotype.Component;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Random;

@Component
public class GenericUtil {

  private final Random rand = SecureRandom.getInstanceStrong();

  public GenericUtil() throws NoSuchAlgorithmException {}

  // generate a six digit random integer.
  public int generateAccessCode() {
    return 100000 + rand.nextInt(900000);
  }
}
