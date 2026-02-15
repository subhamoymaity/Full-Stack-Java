package com.subhamoy.SpringSecurityApp.controller;


import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
//@RequestMapping("/security")  // Base url
public class Test {


  /*  @GetMapping("/start-quiz")
    public String m1()
    {
        return "start-quiz";
    }

    @GetMapping("/login")
    public String m2()
    {
        return "login";
    }*/


   @GetMapping("/contact")
   public String contactUS()
   {
      return "PhoneNO:2345678765432";
   }

   @GetMapping("/updates")
   @PreAuthorize("hasRole('USER')")
   public String updates()
   {
      return "car loan interest drop upto 2%";
   }
   @GetMapping("/admin")
   @PreAuthorize("hasRole('ADMIN')")
   public String admin()
   {
      return "admin ...HI";
   }

   @GetMapping("/check")
   @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")   //user of admin can access
   public String checkBalance()
   {
      return "1000000";
   }

   @GetMapping("/transfer")
   public String transfer()
   {
      return "Transfer done....";
   }
}

