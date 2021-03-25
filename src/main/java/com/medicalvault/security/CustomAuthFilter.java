/** */
package com.medicalvault.security;

import com.medicalvault.service.JWTTokenService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/** @author vikramsingh */
public class CustomAuthFilter extends UsernamePasswordAuthenticationFilter {

  private static Logger logger = LoggerFactory.getLogger(CustomAuthFilter.class);
  @Autowired UserDetailsService userDetailsService;

  @Autowired
  JWTTokenService jwtTokenService;

  @Override
  public void doFilter(
      ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
      throws IOException, ServletException {
    logger.info("Doing filter...");
    HttpServletRequest request = (HttpServletRequest) servletRequest;
    String authToken = request.getHeader(SecurityConstants.JWT_HEADER_STRING);
    String username = jwtTokenService.extractUserNameFromToken(authToken);

    if (username != null && SecurityContextHolder.getContext().getAuthentication() == null) {
      UserDetails userDetails = userDetailsService.loadUserByUsername(username);
      if (jwtTokenService.checkTokenValidity(authToken, userDetails)) {
        UsernamePasswordAuthenticationToken authentication =
            new UsernamePasswordAuthenticationToken(
                userDetails, null, userDetails.getAuthorities());
        authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
        SecurityContextHolder.getContext().setAuthentication(authentication);
      }
    }
    logger.info("Dofilter : authtoken :" + authToken + " username : " + username);
    filterChain.doFilter(request, servletResponse);
  }
}
