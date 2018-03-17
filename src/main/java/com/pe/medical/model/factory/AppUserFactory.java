package com.pe.medical.model.factory;

import org.springframework.security.core.authority.AuthorityUtils;

import com.pe.medical.domain.User;
import com.pe.medical.model.AppUser;

public class AppUserFactory {
	public static AppUser create(User user) {
		return new AppUser(user.getId(), user.getUsername(), user.getPassword(), user.getEmailId(),
				null, AuthorityUtils.commaSeparatedStringToAuthorityList(user.getAuthorities()));
	}
}
