package com.pe.medical.repository;

import com.pe.medical.domain.MedicalRecordsEntity;
import com.pe.medical.domain.User;
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
public class MedicalRecordsRepositoryTest {

  @Autowired TestEntityManager testEntityManager;

  @Autowired UserRepository userRepository;

  @Autowired MedicalRecordsRepository medicalRecordsRepository;

  @Test
  public void whenFindByUserId_thenReturnMedicalRecords() {

    System.out.println("Running tests on medicalRecords repository...");

    User user = new User("MedicalRecordUser", "MEdical", "Teste", null, null, null, null);
    testEntityManager.persist(user);

    MedicalRecordsEntity medicalRecordsEntity = new MedicalRecordsEntity();
    medicalRecordsEntity.setUser(user);
    testEntityManager.persist(medicalRecordsEntity);
    testEntityManager.flush();
    List<MedicalRecordsEntity> medicalRecords =
        medicalRecordsRepository.findAllMedicalRecordeForUserId(user.getId());

    assertThat(!medicalRecords.isEmpty() && medicalRecords.size() == 1);
  }
}
