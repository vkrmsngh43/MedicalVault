package com.medicalvault.service.impl;

import com.medicalvault.domain.UserRoles;
import com.medicalvault.service.AccessSecurityService;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

/**
 * Custom access roles.
 *
 * @author vikramsingh
 */
@Service
public class AccessSecurityServiceImpl implements AccessSecurityService {

  @Override
  public Boolean hasAccessToMedicalRecords() {
    return SecurityContextHolder.getContext()
        .getAuthentication()
        .getAuthorities()
        .contains(new SimpleGrantedAuthority(UserRoles.DOCTOR.toString()));
  }

  @Override
  public Boolean hasAccessToPrescriptionRecords() {
    return SecurityContextHolder.getContext()
        .getAuthentication()
        .getAuthorities()
        .contains(new SimpleGrantedAuthority(UserRoles.PHARMACIST.toString()));
  }
}
