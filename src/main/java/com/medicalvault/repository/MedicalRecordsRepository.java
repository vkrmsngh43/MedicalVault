package com.medicalvault.repository;

import com.medicalvault.domain.MedicalRecordsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MedicalRecordsRepository extends JpaRepository<MedicalRecordsEntity, Long> {

  @Query("Select mre from MedicalRecordsEntity mre where mre.user.id = ?1")
  List<MedicalRecordsEntity> findAllMedicalRecordeForUserId(Long userId);
}
