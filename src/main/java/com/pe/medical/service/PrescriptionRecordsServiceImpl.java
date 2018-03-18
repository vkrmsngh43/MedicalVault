package com.pe.medical.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pe.medical.constants.ErrorConstants;
import com.pe.medical.domain.PrescriptionRecordsEntity;
import com.pe.medical.model.PrescriptionRecords;
import com.pe.medical.model.PrescriptionRecordsResponse;
import com.pe.medical.model.factory.PrescriptionRecordsFactory;
import com.pe.medical.repository.PrescriptionRecordsRepository;

@Service
public class PrescriptionRecordsServiceImpl implements PrescriptionRecordsService{
	
	private static Logger logger = LoggerFactory.getLogger(PrescriptionRecordsServiceImpl.class);
	
	@Autowired
	PrescriptionRecordsRepository prescriptionRecordsRepository;
	
	@Override
	public PrescriptionRecordsResponse getPrescriptionRecordsOfUser(String userId) {
		PrescriptionRecordsResponse prescriptionRecordsResponse = new PrescriptionRecordsResponse();
		try{
			List<PrescriptionRecordsEntity> prescriptionRecordsEntities = prescriptionRecordsRepository.findAllPrescriptionRecordsByUserId(Long.parseLong(userId));
			List<PrescriptionRecords> prescriptionRecords = new ArrayList<>();
			if(prescriptionRecordsEntities != null && prescriptionRecordsEntities.size() > 0){
				for (Iterator<PrescriptionRecordsEntity> iterator = prescriptionRecordsEntities.iterator(); iterator.hasNext();) {
					PrescriptionRecordsEntity prescriptionRecordsEntity = (PrescriptionRecordsEntity) iterator.next();
					prescriptionRecords.add(PrescriptionRecordsFactory.create(prescriptionRecordsEntity));
				}
				prescriptionRecordsResponse.setPrescriptionRecords(prescriptionRecords);
				prescriptionRecordsResponse.setStatusCode(ErrorConstants.SUCCESS_STATUS_CODE);
				prescriptionRecordsResponse.setMessage(ErrorConstants.SUCCESS_MESSAGE);
			}else{
				prescriptionRecordsResponse.setStatusCode(ErrorConstants.SUCCESS_STATUS_CODE);
				prescriptionRecordsResponse.setMessage(ErrorConstants.ERR_PRESCRIPTION_RECORDS_NOT_FOUND);
			}
			
		}catch(Exception ex) {
			logger.error("An error occurred while getting prescription records for userId : " + userId + " Message : " + ex.getMessage());
			prescriptionRecordsResponse.setStatusCode(ErrorConstants.FAILED_STATUS_CODE);
			prescriptionRecordsResponse.setMessage(ErrorConstants.ERR_PROCESSING_PRESCRIPTION_RECORDS);
		}
		
		return prescriptionRecordsResponse;
	}

}
