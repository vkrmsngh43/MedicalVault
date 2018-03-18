package com.pe.medical.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.pe.medical.domain.PrescriptionRecordsEntity;

public interface PrescriptionRecordsRepository extends JpaRepository<PrescriptionRecordsEntity, Long>{
	
	@Query("Select pre from PrescriptionRecordsEntity pre where pre.user.id = ?1")
	List<PrescriptionRecordsEntity> findAllPrescriptionRecordsByUserId(Long userId);
}
