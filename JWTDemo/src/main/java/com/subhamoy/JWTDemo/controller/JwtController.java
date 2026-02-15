package com.subhamoy.JWTDemo.controller;

import com.subhamoy.JWTDemo.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping
public class JwtController {

   @Autowired
   private JwtUtil jwtUtil;


   @PostMapping("/generate-token")
   public String generateToken(@RequestParam String username, @RequestParam String password) {
      if ("admin".equals(username) && "admin".equals(password)) {
         return jwtUtil.generateToken(username);
      } else {
         return "Invalid Credentials!";
      }
   }


   @GetMapping("/contact")
   public String contact() {
      return "Contact US at :092098209102";
   }


   @GetMapping("/fund-transfer")
   public String secureApi(@RequestHeader(value = "Authorization", required = false) String authorizationHeader) {
      if (authorizationHeader != null && authorizationHeader.startsWith("Bearer ")) {
         String token = authorizationHeader.substring(7);

         // Validate the token
         if (jwtUtil.validateToken(token)) {
            String username = jwtUtil.extractUsername(token);
            return "This is a secured API, token validated for user: " + username;
         } else {
            return "Invalid token!";
         }
      } else {
         return "Authorization header is missing or malformed!";
      }
   }

}