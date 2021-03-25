package com.medicalvault.domain;

import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "t_user_medical_records")
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true, callSuper = false)
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MedicalRecordsEntity extends BaseDao {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  private Long id;

  @ManyToOne
  @JoinColumn(name = "user_id")
  private User user;

  @Column(name = "hospital")
  private String hospital;

  @Column(name = "referred_by_hospital")
  private String referringHospital;

  @Column(name = "doctor")
  private String doctor;

  @Column(name = "referred_by_doctor")
  private String referringDoctor;

  @Column(name = "problems")
  private String problems;

  @Column(name = "medications")
  private String medications;

  @Column(name = "allergies")
  private String allergies;

  @Column(name = "medical_history")
  private String medicalHistory;

  @Column(name = "created_at")
  private Date createdDate;
}
