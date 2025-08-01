package org.example;

public class Car {
   IEngine engine;

Car(){
   System.out.println("car constructor...");
}
/*
 if use constructor injection , create a constructor engine here
Car(IEngine engine){
   this.engine=engine;
}
*/

   public void setEngine(IEngine engine) {
      System.out.println("calling setter method...");
      this.engine = engine;
   }
   void drive(){
      int start = engine.start();
      if(start>0){
         System.out.println("car started...");
      }
      else{
         System.out.println("car not started...");
      }
   }

}
