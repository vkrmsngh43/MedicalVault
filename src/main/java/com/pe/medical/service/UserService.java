package com.pe.medical.service;

import java.util.Optional;

import com.pe.medical.domain.User;

public interface UserService {
	
	public User getUserByName(String username);
	public Optional<User> getUserById(Long id);
}
