package com.Subhamoy.SpringBootP03.beans;

import org.springframework.stereotype.Component;

@Component
public class PaytmPay implements Patners{

   PaytmPay()
   {
      System.out.println("PaytmPay constructor...");
   }
   @Override
   public void payment(String amount) {
      System.out.println("PaytmPay payment done for = "+amount);
   }
}