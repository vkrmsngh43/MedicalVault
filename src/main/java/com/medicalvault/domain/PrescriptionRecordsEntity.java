package com.pe.medical.domain;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "t_user_medical_prescriptions")
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

  public PrescriptionRecordsEntity() {
    super();
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public User getUser() {
    return user;
  }

  public void setUser(User user) {
    this.user = user;
  }

  public User getPrescribedBy() {
    return prescribedBy;
  }

  public void setPrescribedBy(User prescribedBy) {
    this.prescribedBy = prescribedBy;
  }

  public String getMedicalCondition() {
    return medicalCondition;
  }

  public void setMedicalCondition(String medicalCondition) {
    this.medicalCondition = medicalCondition;
  }

  public int getMedicDuration() {
    return medicDuration;
  }

  public void setMedicDuration(int medicDuration) {
    this.medicDuration = medicDuration;
  }

  public String getAllergies() {
    return allergies;
  }

  public void setAllergies(String allergies) {
    this.allergies = allergies;
  }

  public String getPrescription() {
    return prescription;
  }

  public void setPrescription(String prescription) {
    this.prescription = prescription;
  }

  public String getPrescriptionNotes() {
    return prescriptionNotes;
  }

  public void setPrescriptionNotes(String prescriptionNotes) {
    this.prescriptionNotes = prescriptionNotes;
  }

  public Date getCreatedDate() {
    return createdDate;
  }

  public void setCreatedDate(Date createdDate) {
    this.createdDate = createdDate;
  }
}
