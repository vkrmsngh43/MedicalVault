package com.medicalvault.domain;

import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "t_user_medical_prescriptions")
@Data
@Builder
@EqualsAndHashCode(onlyExplicitlyIncluded = true, callSuper = false)
@AllArgsConstructor
@NoArgsConstructor
public class PrescriptionRecordsEntity extends BaseDao {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  private Long id;

  @ManyToOne
  @JoinColumn(name = "user_id")
  private User user;

  @ManyToOne
  @JoinColumn(name = "prescribed_by")
  private User prescribedBy;

  ;

  @Column(name = "medical_condition")
  private String medicalCondition;

  @Column(name = "medic_duration")
  private int medicDuration;

  @Column(name = "allergies")
  private String allergies;

  @Column(name = "prescription")
  private String prescription;

  @Column(name = "prescription_notes")
  private String prescriptionNotes;

  @Column(name = "created_at")
  private Date createdDate;

}
