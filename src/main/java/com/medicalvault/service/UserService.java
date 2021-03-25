package com.pe.medical.service;

import com.pe.medical.domain.User;

import java.util.Optional;

public interface UserService {

  public User getUserByName(String username);

  public Optional<User> getUserById(Long id);
}
