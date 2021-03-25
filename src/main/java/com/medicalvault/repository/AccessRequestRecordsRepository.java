package com.medicalvault.repository;

import com.medicalvault.domain.AccessRequestRecords;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface AccessRequestRecordsRepository extends JpaRepository<AccessRequestRecords, Long> {

  @Query(
      "Select arr from AccessRequestRecords arr where arr.user.id = ?1 AND arr.requestedBy.id = ?2 AND arr.accessCode=?3")
  AccessRequestRecords getAccessRequestRecordsByRequesterIdAndUserId(
      Long userId, Long requesterId, String accessCode);
}
