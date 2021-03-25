package com.medicalvault.service;

import com.medicalvault.constants.ErrorConstants;
import com.medicalvault.domain.PrescriptionRecordsEntity;
import com.medicalvault.model.PrescriptionRecords;
import com.medicalvault.model.PrescriptionRecordsResponse;
import com.medicalvault.model.factory.PrescriptionRecordsFactory;
import com.medicalvault.repository.PrescriptionRecordsRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class PrescriptionRecordsServiceImpl implements PrescriptionRecordsService {

  @Autowired PrescriptionRecordsRepository prescriptionRecordsRepository;

  @Override
  public PrescriptionRecordsResponse getPrescriptionRecordsOfUser(String userId) {
    PrescriptionRecordsResponse prescriptionRecordsResponse = new PrescriptionRecordsResponse();
    try {
      List<PrescriptionRecordsEntity> prescriptionRecordsEntities =
          prescriptionRecordsRepository.findAllPrescriptionRecordsByUserId(Long.parseLong(userId));
      List<PrescriptionRecords> prescriptionRecords = new ArrayList<>();
      if (prescriptionRecordsEntities == null || prescriptionRecordsEntities.isEmpty()) {
        prescriptionRecordsResponse.setStatusCode(ErrorConstants.SUCCESS_STATUS_CODE);
        prescriptionRecordsResponse.setMessage(ErrorConstants.ERR_PRESCRIPTION_RECORDS_NOT_FOUND);
        return prescriptionRecordsResponse;
      }
      for (PrescriptionRecordsEntity prescriptionRecordsEntity : prescriptionRecordsEntities) {
        prescriptionRecords.add(PrescriptionRecordsFactory.create(prescriptionRecordsEntity));
      }
      prescriptionRecordsResponse.setPrescriptionRecords(prescriptionRecords);
      prescriptionRecordsResponse.setStatusCode(ErrorConstants.SUCCESS_STATUS_CODE);
      prescriptionRecordsResponse.setMessage(ErrorConstants.SUCCESS_MESSAGE);

    } catch (Exception ex) {
      log.error(
          "An error occurred while getting prescription records for userId : {}, Message {} ",
          userId,
          ex.getMessage());
      prescriptionRecordsResponse.setStatusCode(ErrorConstants.FAILED_STATUS_CODE);
      prescriptionRecordsResponse.setMessage(ErrorConstants.ERR_PROCESSING_PRESCRIPTION_RECORDS);
    }

    return prescriptionRecordsResponse;
  }
}
