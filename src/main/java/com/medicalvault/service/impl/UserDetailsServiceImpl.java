package com.medicalvault.service.impl;

import com.medicalvault.domain.User;
import com.medicalvault.model.factory.AppUserFactory;
import com.medicalvault.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class UserDetailsServiceImpl implements UserDetailsService {

  @Autowired UserRepository userRepository;

  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    User user = userRepository.findByUsername(username);
    if (user == null)
      throw new UsernameNotFoundException(
          String.format("No user found with username '%s'.", username));

    return AppUserFactory.create(user);
  }
}
