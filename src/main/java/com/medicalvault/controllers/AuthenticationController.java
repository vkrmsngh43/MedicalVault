package com.pe.medical.controllers;

import com.pe.medical.constants.ErrorConstants;
import com.pe.medical.domain.User;
import com.pe.medical.helper.DateTimeHelper;
import com.pe.medical.model.AppUserRequest;
import com.pe.medical.model.AuthenticationResponse;
import com.pe.medical.model.SignupRequest;
import com.pe.medical.repository.UserRepository;
import com.pe.medical.service.JWTTokenService;
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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

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
  @RequestMapping(method = RequestMethod.POST)
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
   * @param signupRequest
   * @return
   * @throws AuthenticationException
   */
  @RequestMapping(value = "/signup", method = RequestMethod.POST)
  public ResponseEntity<?> userSignup(@RequestBody SignupRequest signupRequest)
      throws AuthenticationException {
    Date currentTime = DateTimeHelper.getCurrentDate();

    User newUser =
        new User(
            signupRequest.getUsername(),
            signupRequest.getFirstName(),
            signupRequest.getLastName(),
            new BCryptPasswordEncoder().encode(signupRequest.getPassword()),
            signupRequest.getPhoneNumber(),
            signupRequest.getEmailId(),
            signupRequest.getUserType().toUpperCase());
    newUser.setCreatedDate(currentTime);
    userRepository.save(newUser);
    return ResponseEntity.ok("Successfully Registered");
  }
}
