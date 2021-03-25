package com.pe.medical.controllers;

import com.pe.medical.service.AccessRequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/userrecords")
public class AccessRequestController {

  @Autowired AccessRequestService accessRequestService;
  /**
   * This API is called to place an access request before accessing the medical records of a
   * patient.
   *
   * @param userId
   * @return
   * @throws Exception
   */
  @RequestMapping(value = "/request-access/user/{userId}", method = RequestMethod.GET)
  @PreAuthorize(
      "@accessSecurityService.hasAccessToMedicalRecords() OR @accessSecurityService.hasAccessToPrescriptionRecords()")
  public ResponseEntity<String> requestAccess(@PathVariable("userId") String userId)
      throws Exception {
    accessRequestService.placeAccessRequest(userId);
    return new ResponseEntity<String>("Access Request has been placed", HttpStatus.OK);
  }
}
