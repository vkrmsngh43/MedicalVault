package com.medicalvault.model.factory;

import com.medicalvault.model.AppUser;
import com.medicalvault.domain.User;
import org.springframework.security.core.authority.AuthorityUtils;

public class AppUserFactory {
  public static AppUser create(User user) {
    return new AppUser(
        user.getId(),
        user.getUsername(),
        user.getPassword(),
        user.getEmailId(),
        null,
        AuthorityUtils.commaSeparatedStringToAuthorityList(user.getAuthorities()));
  }
}
