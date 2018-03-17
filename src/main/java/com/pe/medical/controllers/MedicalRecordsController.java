package com.pe.medical.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.pe.medical.helper.SecurityContextHelper;
import com.pe.medical.model.MedicalRecordsResponse;
import com.pe.medical.service.AccessRequestService;
import com.pe.medical.service.MedicalRecordsService;

@RestController
@RequestMapping("/medicalrecords")
public class MedicalRecordsController {

	private static Logger logger = LoggerFactory.getLogger(MedicalRecordsController.class);

	@Autowired
	MedicalRecordsService medicalRecordsService;

	@Autowired
	AccessRequestService accessRequestService;
	
	@Autowired SecurityContextHelper securityContextHelper;

	@RequestMapping(value = "/request-access/user/{userId}", method = RequestMethod.GET)
	@PreAuthorize("@accessSecurityService.hasAccessToMedicalRecords()")
	public ResponseEntity<String> requestAccess(@PathVariable("userId") String userId) throws Exception {
		accessRequestService.placeAccessRequest(userId);
		return new ResponseEntity<String>("Access Request has been placed", HttpStatus.OK);
	}

	@RequestMapping(value = "/find/{userId}/accesscode/{accesscode}", method = RequestMethod.GET)
	@PreAuthorize("@accessSecurityService.hasAccessToMedicalRecords()")
	public ResponseEntity<MedicalRecordsResponse> getMedicalRecords(@PathVariable("userId") String userId, @PathVariable("accesscode") String accessCode) {
		
		boolean isValidAccessCode = accessRequestService.verifyAccessCode(userId, securityContextHelper.getCurrentUserId(), accessCode);
		
		logger.info("IsValid accessCode? " + isValidAccessCode);
		MedicalRecordsResponse response = medicalRecordsService.getMedicalRecordsByUserId(Long.parseLong(userId));

		return ResponseEntity.ok(response);
	}

}
