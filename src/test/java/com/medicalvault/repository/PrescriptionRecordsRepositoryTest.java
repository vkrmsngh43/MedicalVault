package com.medicalvault.repository;

import com.medicalvault.domain.PrescriptionRecordsEntity;
import com.medicalvault.domain.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
public class PrescriptionRecordsRepositoryTest {

  @Autowired TestEntityManager testEntityManager;

  @Autowired UserRepository userRepository;

  @Autowired PrescriptionRecordsRepository prescriptionRecordsRepository;

  @Test
  public void whenFindByUserId_thenReturnPrescriptionRecords() {
    System.out.println("Running tests on Prescription Records repository...");

    // create user
    User user =
            User.builder().username("MedicalRecordUser").firstName("Medical").lastName("Teste").build();
    testEntityManager.persist(user);
    // create doctor
    User doctor =
            User.builder().username("MedicalRecordDoctor").firstName("Doctor").lastName("Teste").build();
    testEntityManager.persist(doctor);
    // create prescription
    PrescriptionRecordsEntity prescriptionRecordsEntity = new PrescriptionRecordsEntity();
    prescriptionRecordsEntity.setUser(user);
    prescriptionRecordsEntity.setPrescribedBy(doctor);
    testEntityManager.persist(prescriptionRecordsEntity);
    testEntityManager.flush();

    List<PrescriptionRecordsEntity> prescriptionRecords =
        prescriptionRecordsRepository.findAllPrescriptionRecordsByUserId(user.getId());

    assertThat(!prescriptionRecords.isEmpty() && prescriptionRecords.size() == 1);
  }
}
