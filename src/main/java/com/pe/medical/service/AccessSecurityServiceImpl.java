package com.pe.medical.service;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.pe.medical.domain.UserRoles;

@Service
public class AccessSecurityServiceImpl implements AccessSecurityService{

	@Override
	public Boolean hasAccessToMedicalRecords() {
		return SecurityContextHolder.getContext()
				.getAuthentication().getAuthorities()
				.contains(new SimpleGrantedAuthority(UserRoles.DOCTOR.toString()));
	}

	@Override
	public Boolean hasAccessToPrescriptionRecords() {
		return SecurityContextHolder.getContext()
				.getAuthentication().getAuthorities()
				.contains(new SimpleGrantedAuthority(UserRoles.PRACTITIONER.toString()));
	}

}
