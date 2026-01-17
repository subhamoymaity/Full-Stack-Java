package com.Subhamoy.SpringBootP03.beans;

import org.springframework.stereotype.Component;

@Component
public class RozerPay implements Patners{

   RozerPay()
   {
      System.out.println("RozerPay constructor...");
   }
   @Override
   public void payment(String amount) {
      System.out.println("RozerPay payment done for = "+amount);
   }
}
