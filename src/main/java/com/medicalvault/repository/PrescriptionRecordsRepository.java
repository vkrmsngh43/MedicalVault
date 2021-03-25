package com.pe.medical.repository;

import com.pe.medical.domain.PrescriptionRecordsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PrescriptionRecordsRepository
    extends JpaRepository<PrescriptionRecordsEntity, Long> {

  @Query("Select pre from PrescriptionRecordsEntity pre where pre.user.id = ?1")
  List<PrescriptionRecordsEntity> findAllPrescriptionRecordsByUserId(Long userId);
}
