package com.pe.medical.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.pe.medical.domain.MedicalRecordsEntity;

public interface MedicalRecordsRepository extends JpaRepository<MedicalRecordsEntity, Long>{
	
	@Query("Select mre from MedicalRecordsEntity mre where mre.user.id = ?1")
	List<MedicalRecordsEntity> findAllMedicalRecordeForUserId(Long userId);
}
