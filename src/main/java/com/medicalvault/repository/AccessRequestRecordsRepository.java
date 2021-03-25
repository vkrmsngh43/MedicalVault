package com.pe.medical.repository;

import com.pe.medical.domain.AccessRequestRecords;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface AccessRequestRecordsRepository extends JpaRepository<AccessRequestRecords, Long> {

  @Query(
      "Select arr from AccessRequestRecords arr where arr.user.id = ?1 AND arr.requestedBy.id = ?2 AND arr.accessCode=?3")
  AccessRequestRecords getAccessRequestRecordsByRequesterIdAndUserId(
      Long userId, Long requesterId, String accessCode);
}
