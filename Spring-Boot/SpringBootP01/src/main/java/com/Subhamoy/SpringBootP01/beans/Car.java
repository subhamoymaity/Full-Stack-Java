package com.Subhamoy.SpringBootP01.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
//“Hey Spring, I’m a bean. Please create and manage an object of this class and keep it in the IOC container.”
public class Car {
   @Autowired
   Petrol petrol;

   public void m1() {
      petrol.start();
   }
}
