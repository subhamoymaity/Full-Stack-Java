package setterInjectiion;

import looseCouple.DieselEngine;
import looseCouple.Engine;
import looseCouple.PetrolEngine;

public class Main {
   public static void main(String[] args) {
      // Create the car and engine separately
      Car car = new Car();

      // Inject PetrolEngine using setter method
      Engine petrolEngine = new PetrolEngine();
      car.setEngine(petrolEngine);
      car.startCar();

      System.out.println("-----");

      // Inject DieselEngine using setter method
      Engine dieselEngine = new DieselEngine();
      car.setEngine(dieselEngine);
      car.startCar();
   }
}

