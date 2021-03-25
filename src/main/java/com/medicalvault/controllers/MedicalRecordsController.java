package com.pe.medical.controllers;

import com.pe.medical.constants.ErrorConstants;
import com.pe.medical.helper.SecurityContextHelper;
import com.pe.medical.model.MedicalRecordsResponse;
import com.pe.medical.service.AccessRequestService;
import com.pe.medical.service.MedicalRecordsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/medicalrecords")
public class MedicalRecordsController {

  @Autowired MedicalRecordsService medicalRecordsService;

  @Autowired SecurityContextHelper securityContextHelper;

  @Autowired AccessRequestService accessRequestService;
  /**
   * After verifying the access code, this API would send the response accordingly.
   *
   * @param userId
   * @param accessCode
   * @return
   */
  @RequestMapping(value = "/find/{userId}/accesscode/{accesscode}", method = RequestMethod.GET)
  @PreAuthorize("@accessSecurityService.hasAccessToMedicalRecords()")
  public ResponseEntity<MedicalRecordsResponse> getMedicalRecords(
      @PathVariable("userId") String userId, @PathVariable("accesscode") String accessCode) {

    MedicalRecordsResponse response = new MedicalRecordsResponse();
    boolean isVerified =
        accessRequestService.verifyAccessCode(
            userId, securityContextHelper.getCurrentUserId(), accessCode);

    if (isVerified) {
      response = medicalRecordsService.getMedicalRecordsByUserId(Long.parseLong(userId));
      response.setStatusCode(ErrorConstants.SUCCESS_STATUS_CODE);
      response.setMessage(ErrorConstants.SUCCESS_MESSAGE);
    } else {
      response.setStatusCode(ErrorConstants.FAILED_STATUS_CODE);
      response.setMessage(ErrorConstants.ACCESS_CODE_INVALID);
    }

    return ResponseEntity.ok(response);
  }
}
