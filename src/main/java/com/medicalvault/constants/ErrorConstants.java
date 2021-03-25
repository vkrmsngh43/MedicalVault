package com.pe.medical.constants;

public class ErrorConstants {

  public static int SUCCESS_STATUS_CODE = 1;
  public static int FAILED_STATUS_CODE = -1;

  public static String ACCESS_CODE_INVALID =
      "Provided access code is either not valid or expired. Please try again.";

  public static String SUCCESS_MESSAGE = "success";

  public static String ERR_PROCESSING_PRESCRIPTION_RECORDS =
      "An error occurred while getting prescription records";
  public static String ERR_PRESCRIPTION_RECORDS_NOT_FOUND =
      "Prescription records for provided userId not found.";
}
