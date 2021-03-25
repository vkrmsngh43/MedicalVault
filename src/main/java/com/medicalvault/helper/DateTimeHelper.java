package com.medicalvault.helper;

import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class DateTimeHelper {

  public static Date getCurrentDate() {
    return new Date(System.currentTimeMillis());
  }

  public static Date getExpirationDate(Long duration) {
    return new Date(System.currentTimeMillis() + duration * 1000);
  }
}
