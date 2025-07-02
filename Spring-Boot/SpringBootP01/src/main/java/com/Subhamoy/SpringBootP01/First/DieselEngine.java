package com.Subhamoy.SpringBootP01.First;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
//@Primary
@Component
public class DieselEngine implements Engine {
   public void start() {
      System.out.println("Diesel Engine Started...");
   }
}
