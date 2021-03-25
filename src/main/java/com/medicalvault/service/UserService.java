package com.medicalvault.service;

import com.medicalvault.domain.User;

import java.util.Optional;

public interface UserService {

  User getUserByName(String username);

  Optional<User> getUserById(Long id);
}
