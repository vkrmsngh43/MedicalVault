package com.pe.medical.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pe.medical.domain.User;

public interface UserRepository extends JpaRepository<User, Long>{
	public User findByUsername(String username);
}
