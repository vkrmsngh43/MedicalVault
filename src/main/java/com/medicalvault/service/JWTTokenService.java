package com.pe.medical.service;

import com.pe.medical.helper.DateTimeHelper;
import com.pe.medical.model.AppUser;
import com.pe.medical.security.SecurityConstants;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Component
public class JWTTokenService {

  private static Logger logger = LoggerFactory.getLogger(JWTTokenService.class);
  /**
   * Extracts userName from the input token.
   *
   * @param token
   * @return
   */
  public String extractUserNameFromToken(String token) {
    String userName = null;
    try {
      Claims claims = getClaimsFromToken(token);
      logger.info("Claims : " + claims.getSubject());
      userName = claims != null ? claims.getSubject() : null;
    } catch (Exception ex) {
      logger.error("Error extracting username from token " + ex.getMessage());
      // ex.printStackTrace();
    }
    return userName;
  }

  /**
   * Extracts Expiry date from the token.
   *
   * @param token
   * @return
   */
  public Date extractExpirationDateFromToken(String token) {
    Date expiration = null;
    try {
      final Claims claims = this.getClaimsFromToken(token);
      expiration = claims.getExpiration();
    } catch (Exception ex) {
      logger.error("Error extracting Expiry date from token " + ex.getMessage());
      // ex.printStackTrace();
    }
    return expiration;
  }

  private Claims getClaimsFromToken(String token) {
    Claims claims = null;
    try {
      claims =
          Jwts.parser().setSigningKey(SecurityConstants.JWT_SECRET).parseClaimsJws(token).getBody();
    } catch (Exception ex) {
      logger.error("Error parsing claims from token " + ex.getMessage());
      // ex.printStackTrace();
    }
    return claims;
  }
  /**
   * Generates a JWT token
   *
   * @param userDetails
   * @return
   */
  public String generateToken(UserDetails userDetails) {
    logger.info("Generating claims for username :" + userDetails.getUsername());
    Map<String, Object> claims = new HashMap<String, Object>();
    claims.put("sub", userDetails.getUsername());
    claims.put("created", DateTimeHelper.getCurrentDate());
    return Jwts.builder()
        .setClaims(claims)
        .setExpiration(DateTimeHelper.getExpirationDate(SecurityConstants.TOKEN_EXPIRATION_TIME))
        .signWith(SignatureAlgorithm.HS512, SecurityConstants.JWT_SECRET)
        .compact();
  }
  /**
   * Checks if the token has not expired already.
   *
   * @param token
   * @return
   */
  private Boolean checkTokenExpiry(String token) {
    final Date expiration = this.extractExpirationDateFromToken(token);
    return expiration.before(DateTimeHelper.getCurrentDate());
  }
  /**
   * Checks the token's validity.
   *
   * @param token
   * @param userDetails
   * @return
   */
  public Boolean checkTokenValidity(String token, UserDetails userDetails) {
    AppUser user = (AppUser) userDetails;
    final String username = this.extractUserNameFromToken(token);
    return (username.equals(user.getUsername()) && !(this.checkTokenExpiry(token)));
  }
}
