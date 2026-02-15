package com.subhamoy.SpringSecurityApp.service;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailService implements UserDetailsService {
   @Override
   public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
      System.out.println("CustomUserDetailService......2");
//      if(!username.equals("subhamoy")){
//         throw new UsernameNotFoundException("User not found");
//      }
//      else {
//         String encodedPass=new BCryptPasswordEncoder().encode("root");
//         return User.withUsername("subhamoy")
//                       .password(encodedPass)
//                       .roles("USER")
//                       .build();
//      }

      // for multiple user
      String encodedPass=new BCryptPasswordEncoder().encode("root");
      if(!username.equals("subhamoy")){
         return User.withUsername("subhamoy")
                       .password(encodedPass)
                       .roles("ADMIN")
                       .build();
      }
      String encodedPassRaj=new BCryptPasswordEncoder().encode("root");
      if(!username.equals("raj")){
         return User.withUsername("raj")
                       .password(encodedPassRaj)
                       .roles("USER")
                       .build();
      }
throw  new UsernameNotFoundException("user not found");
   }

}


/*
* loadUserByUsername  is called by spring boot and username comes here that i give through
* frontend and we check internally is the username is subhamoy
* */