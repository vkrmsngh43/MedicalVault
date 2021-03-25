package com.medicalvault.domain;

import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "t_access_request_records")
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true, callSuper = false)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AccessRequestRecords extends BaseDao {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  private Long id;

  @ManyToOne
  @JoinColumn(name = "user_id")
  private User user;

  @ManyToOne
  @JoinColumn(name = "requested_by_user_id")
  private User requestedBy;

  @Column(name = "access_code")
  private String accessCode;

  @Column(name = "access_code_generated_at")
  private Date accessCodeGeneratedAt;

  @Column(name = "status")
  private String status;

  @Column(name = "access_code_ttl")
  private int accessCodeTtl;

  @Column(name = "created_at")
  private Date createdDate;
}
