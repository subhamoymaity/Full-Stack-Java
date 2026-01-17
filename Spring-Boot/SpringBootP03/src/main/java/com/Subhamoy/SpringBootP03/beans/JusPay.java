package com.Subhamoy.SpringBootP03.beans;

import org.springframework.stereotype.Component;

@Component
public class JusPay implements Patners{

   JusPay()
   {
      System.out.println("JusPay constructor...");
   }
   @Override
   public void payment(String amount) {

      System.out.println("JusPay payment done for = "+amount);

   }
}
