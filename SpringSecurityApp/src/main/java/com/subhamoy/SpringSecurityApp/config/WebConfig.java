package com.subhamoy.SpringSecurityApp.config;
import com.subhamoy.SpringSecurityApp.service.CustomUserDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
@EnableWebSecurity   //when we try to apply custom authorization
@EnableMethodSecurity  // without this  admin will run when giving username raj
public class WebConfig {
   @Autowired
   private CustomUserDetailService userDetailService;

   @Bean
   public SecurityFilterChain securityFilter(HttpSecurity httpSecurity) throws Exception {
      System.out.println("SecurityFilterChain..........3");
      httpSecurity.authorizeHttpRequests(req ->
                                                req.requestMatchers("/contact","/updates").permitAll()
                                                       .anyRequest().authenticated()
             ).formLogin(withDefaults())
             .httpBasic(withDefaults());

      return httpSecurity.build();
   }
   @Bean
   public PasswordEncoder passwordEncoder(){

      return new BCryptPasswordEncoder();
   }


@Bean
   public AuthenticationManager authenticationManager(HttpSecurity http) throws Exception{
   System.out.println("AuthenticationManager................1");

      AuthenticationManagerBuilder builder=http.getSharedObject(AuthenticationManagerBuilder.class);
      builder.userDetailsService(userDetailService)
             .passwordEncoder(passwordEncoder());

      return builder.build();

   }

}
