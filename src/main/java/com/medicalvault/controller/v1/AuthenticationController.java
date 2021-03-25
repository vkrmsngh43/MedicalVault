package com.medicalvault.controllers;

import com.medicalvault.constants.ErrorConstants;
import com.medicalvault.domain.User;
import com.medicalvault.helper.DateTimeHelper;
import com.medicalvault.model.AppUserRequest;
import com.medicalvault.model.AuthenticationResponse;
import com.medicalvault.model.SignupRequest;
import com.medicalvault.repository.UserRepository;
import com.medicalvault.service.JWTTokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
@RequestMapping("/auth")
public class AuthenticationController {

  @Autowired UserRepository userRepository;

  @Autowired UserDetailsService userDetailsService;

  @Autowired AuthenticationManager authenticationManager;

  @Autowired JWTTokenService jwtTokenService;

  /**
   * Login URL.
   *
   * @param appUserRequest
   * @return
   * @throws AuthenticationException
   */
  @PostMapping
  public ResponseEntity<?> authenticate(@RequestBody AppUserRequest appUserRequest)
      throws AuthenticationException {
    Authentication authentication =
        this.authenticationManager.authenticate(
            new UsernamePasswordAuthenticationToken(
                appUserRequest.getUsername(), appUserRequest.getPassword()));
    SecurityContextHolder.getContext().setAuthentication(authentication);

    // Reload password post-authentication so we can generate token
    UserDetails userDetails =
        this.userDetailsService.loadUserByUsername(appUserRequest.getUsername());
    String token = jwtTokenService.generateToken(userDetails);
    return ResponseEntity.ok(
        new AuthenticationResponse(
            token, ErrorConstants.SUCCESS_STATUS_CODE, ErrorConstants.SUCCESS_MESSAGE));
  }

  /**
   * Register a new user.
   *
   * @param signupRequest SignupRequest
   * @return
   * @throws AuthenticationException
   */
  @PostMapping(value = "/signup")
  public ResponseEntity<?> userSignup(@RequestBody SignupRequest signupRequest)
      throws AuthenticationException {
    Date currentTime = DateTimeHelper.getCurrentDate();

    User newUser =
        User.builder()
            .username(signupRequest.getUsername())
            .firstName(signupRequest.getFirstName())
            .lastName(signupRequest.getLastName())
            .password(new BCryptPasswordEncoder().encode(signupRequest.getPassword()))
            .phoneNumber(signupRequest.getPhoneNumber())
            .emailId(signupRequest.getEmailId())
            .authorities(signupRequest.getUserType().toUpperCase())
            .createdDate(currentTime)
            .build();
    userRepository.save(newUser);
    return ResponseEntity.ok("Successfully Registered");
  }
}
