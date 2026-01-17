package setterInjectiion;

import looseCouple.Engine;

public class Car {
   private Engine engine;

   // Setter method to inject dependency
   public void setEngine(Engine engine) {
      this.engine = engine;
   }

   public void startCar() {
      if (engine != null) {
         System.out.println("Starting the car...");
         engine.start();
      } else {
         System.out.println("Engine not found! Can't start the car.");
      }
   }
}

