package com.pe.medical.controllers;

import com.pe.medical.constants.ErrorConstants;
import com.pe.medical.helper.SecurityContextHelper;
import com.pe.medical.model.PrescriptionRecordsResponse;
import com.pe.medical.service.AccessRequestService;
import com.pe.medical.service.PrescriptionRecordsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/prescriptionrecords")
public class PrescriptionRecordsController {

  @Autowired PrescriptionRecordsService prescriptionRecordsService;

  @Autowired AccessRequestService accessRequestService;

  @Autowired SecurityContextHelper securityContextHelper;

  @RequestMapping(value = "/find/user/{userId}/{accesscode}", method = RequestMethod.GET)
  public ResponseEntity<PrescriptionRecordsResponse> getPrescriptionRecords(
      @PathVariable("userId") String userId, @PathVariable("accesscode") String accessCode) {
    PrescriptionRecordsResponse prescriptionRecordsResponse = new PrescriptionRecordsResponse();

    boolean isVerified =
        accessRequestService.verifyAccessCode(
            userId, securityContextHelper.getCurrentUserId(), accessCode);
    if (isVerified) {
      prescriptionRecordsResponse = prescriptionRecordsService.getPrescriptionRecordsOfUser(userId);
    } else {
      prescriptionRecordsResponse.setStatusCode(ErrorConstants.FAILED_STATUS_CODE);
      prescriptionRecordsResponse.setMessage(ErrorConstants.ACCESS_CODE_INVALID);
    }

    return ResponseEntity.ok(prescriptionRecordsResponse);
  }
}
