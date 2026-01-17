package com.Subhamoy.SpringBootP01.First;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class Car {

   Engine engine;
   @Autowired
    public Car(@Qualifier("dieselEngine") Engine engine) {
      this.engine = engine;
   }

   public void m2(){
      engine.start();
   }
}
