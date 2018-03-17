package com.pe.medical.helper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import com.pe.medical.domain.User;
import com.pe.medical.repository.UserRepository;

@Component
public class SecurityContextHelper {
	
	@Autowired UserRepository userRepository;
	public String getCurrentUserId() {
		User user = getCurrentUser();
		return user != null ? String.valueOf(user.getId()) : null;
	}
	
	public User getCurrentUser() {
		String username = SecurityContextHolder.getContext().getAuthentication().getName();
		return userRepository.findByUsername(username);
		
	}
}
