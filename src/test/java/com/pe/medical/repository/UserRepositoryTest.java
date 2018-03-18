package com.pe.medical.repository;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import com.pe.medical.domain.User;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace=Replace.NONE)
public class UserRepositoryTest {
	
	@Autowired
	private TestEntityManager testEntityManager;
	
	@Autowired
	private UserRepository userRepository;
	
	@Test
	public void whenFindByName_thenReturnUser() {
		System.out.println("Running tests on userRepo....");
		User user = new User("TestUser", "Test", "User", "", "", "", "");
		testEntityManager.persist(user);
		testEntityManager.flush();
		
		User userFound = userRepository.findByUsername("TestUser");
		
		assertThat(userFound.getUsername().equals(user.getUsername()));
	}
}
