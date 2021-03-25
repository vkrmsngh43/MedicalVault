package com.pe.medical.service;

import com.pe.medical.domain.User;
import com.pe.medical.model.factory.AppUserFactory;
import com.pe.medical.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
  private static Logger logger = LoggerFactory.getLogger(UserDetailsServiceImpl.class);
  @Autowired UserRepository userRepository;

  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    try {
      User user = userRepository.findByUsername(username);
      if (user == null) {
        throw new UsernameNotFoundException(
            String.format("No user found with username '%s'.", username));
      } else {
        logger.info("User obtained as : " + user.getUsername());
        return AppUserFactory.create(user);
      }
    } catch (Exception ex) {
      ex.printStackTrace();
    }
    return null;
  }
}
