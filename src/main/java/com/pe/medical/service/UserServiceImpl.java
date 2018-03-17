package com.pe.medical.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.pe.medical.domain.User;
import com.pe.medical.repository.UserRepository;

public class UserServiceImpl implements UserService{
	
	@Autowired UserRepository userRepository;

	@Override
	public User getUserByName(String username) {
		
		return userRepository.findByUsername(username);
	}

	@Override
	public Optional<User> getUserById(Long id) {
		return userRepository.findById(id);
	}
	

}
