package com.pe.medical.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pe.medical.domain.MedicalRecordsEntity;
import com.pe.medical.model.MedicalRecords;
import com.pe.medical.model.MedicalRecordsResponse;
import com.pe.medical.model.factory.MedicalRecordsFactory;
import com.pe.medical.repository.MedicalRecordsRepository;

@Service
public class MedicalRecordsServiceImpl implements MedicalRecordsService{
	
	private static Logger logger = LoggerFactory.getLogger(MedicalRecordsServiceImpl.class);
	
	@Autowired MedicalRecordsRepository medicalRecordsRepository;
	@Override
	public Optional<MedicalRecordsEntity> getMedicalRecordById(Long id) {
		return medicalRecordsRepository.findById(id);
	}

	@Override
	public MedicalRecordsResponse getMedicalRecordsByUserId(Long userId) {
		MedicalRecordsResponse medicalRecordsResponse = new MedicalRecordsResponse();
		try{
			List<MedicalRecordsEntity> medicalRecords = medicalRecordsRepository.findAllMedicalRecordeForUserId(userId);
			if(medicalRecords != null ){
				List<MedicalRecords> medicalRecordsModel = new ArrayList<>();
				
				for (Iterator<MedicalRecordsEntity> iterator = medicalRecords.iterator(); iterator.hasNext();) {
					MedicalRecordsEntity medicalRecordsEntity =  iterator.next();
					medicalRecordsModel.add(MedicalRecordsFactory.create(medicalRecordsEntity));
				}
				medicalRecordsResponse.setMedicalRecords(medicalRecordsModel);
			}
		}catch(Exception ex){
			logger.error("An error while fetching medical records..");
			ex.printStackTrace();
		}
		return medicalRecordsResponse;
		
	}

}
