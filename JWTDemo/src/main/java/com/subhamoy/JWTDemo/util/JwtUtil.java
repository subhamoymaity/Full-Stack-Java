package com.subhamoy.JWTDemo.util;

import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.util.Date;

@Component
public class JwtUtil {

   private static final Logger logger = LoggerFactory.getLogger(JwtUtil.class);

   @Value("${jwt.secret}")
   private String secretKeyString;

   @Value("${jwt.expiration:1800000}") // Default 30 minutes
   private long jwtExpirationMs;

   private Key getSigningKey() {
      return Keys.hmacShaKeyFor(secretKeyString.getBytes());
   }

   public String generateToken(String username) {
      String token = Jwts.builder()
                            .setSubject(username)
                            .setIssuedAt(new Date())
                            .setExpiration(new Date(System.currentTimeMillis() + jwtExpirationMs))
                            .signWith(getSigningKey())
                            .compact();

      logger.info("Generated Token for user: {}", username);
      return token;
   }

   public boolean validateToken(String token) {
      try {
         Jwts.parserBuilder().setSigningKey(getSigningKey()).build().parseClaimsJws(token);
         return true;
      } catch (ExpiredJwtException e) {
         logger.error("Token expired: {}", e.getMessage());
         return false;
      } catch (SignatureException e) {
         logger.error("Invalid JWT signature: {}", e.getMessage());
         return false;
      } catch (MalformedJwtException e) {
         logger.error("Invalid JWT token: {}", e.getMessage());
         return false;
      } catch (UnsupportedJwtException e) {
         logger.error("JWT token is unsupported: {}", e.getMessage());
         return false;
      } catch (JwtException e) {
         logger.error("JWT exception: {}", e.getMessage());
         return false;
      }
   }

   public String extractUsername(String token) {
      return Jwts.parserBuilder()
                    .setSigningKey(getSigningKey())
                    .build()
                    .parseClaimsJws(token)
                    .getBody()
                    .getSubject();
   }
}