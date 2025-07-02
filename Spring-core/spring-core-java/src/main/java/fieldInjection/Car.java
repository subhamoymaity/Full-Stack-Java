package fieldInjection;

import looseCouple.Engine;

public class Car {
   // Field injection (simulated)
   Engine engine;

   public void startCar() {
      if (engine != null) {
         System.out.println("Starting the car...");
         engine.start();
      } else {
         System.out.println("No engine found! Please inject one.");
      }
   }
}

