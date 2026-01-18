package com.Subhamoy.SpringBootP03.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Flipkart {

   @Autowired
//   @Autowired: Spring will inject a bean of type Patners into the pat field.
   @Qualifier("jusPay")
//   This qualifies the specific implementation to use.
   Patners pat;

   @Value("${jdbc.url}")
   private String url;

   Flipkart()
   {
      System.out.println("flipkart constructor...");
   }

   public void paymentGateWay(String amount)
   {
      System.out.println(url);
      pat.payment(amount);
   }
}