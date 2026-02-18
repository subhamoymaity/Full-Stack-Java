package com.subhamoy.hotstar.service;

import com.subhamoy.hotstar.dto.AuthResponse;
import com.subhamoy.hotstar.dto.LoginRequest;
import com.subhamoy.hotstar.dto.RegisterRequest;
import com.subhamoy.hotstar.model.User;
import com.subhamoy.hotstar.repository.UserRepository;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService implements UserDetailsService {

   private final UserRepository userRepository;
   private final PasswordEncoder passwordEncoder;
   private final JwtService jwtService;
   private final AuthenticationManager authenticationManager;

   // ✅ Add @Lazy to AuthenticationManager
   public AuthService(UserRepository userRepository,
                      PasswordEncoder passwordEncoder,
                      JwtService jwtService,
                      @Lazy AuthenticationManager authenticationManager) {
      this.userRepository = userRepository;
      this.passwordEncoder = passwordEncoder;
      this.jwtService = jwtService;
      this.authenticationManager = authenticationManager;
   }

   public AuthResponse register(RegisterRequest request) {
      if (userRepository.existsByEmail(request.getEmail())) {
         throw new RuntimeException("Email already exists");
      }

      User user = new User();
      user.setName(request.getName());
      user.setEmail(request.getEmail());
      user.setPassword(passwordEncoder.encode(request.getPassword()));

      userRepository.save(user);

      String jwtToken = jwtService.generateToken(user);
      return new AuthResponse(jwtToken, user.getName(), user.getEmail());
   }

   public AuthResponse login(LoginRequest request) {
      authenticationManager.authenticate(
             new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword())
      );

      User user = userRepository.findByEmail(request.getEmail())
                         .orElseThrow(() -> new RuntimeException("User not found"));

      String jwtToken = jwtService.generateToken(user);
      return new AuthResponse(jwtToken, user.getName(), user.getEmail());
   }

   @Override
   public User loadUserByUsername(String email) throws UsernameNotFoundException {
      return userRepository.findByEmail(email)
                    .orElseThrow(() -> new UsernameNotFoundException("User not found"));
   }
}