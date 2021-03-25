package com.pe.medical.model.factory;

import com.pe.medical.domain.User;
import com.pe.medical.model.AppUser;
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
