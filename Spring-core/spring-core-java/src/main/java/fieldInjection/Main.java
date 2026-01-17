package fieldInjection;

import looseCouple.DieselEngine;
import looseCouple.PetrolEngine;

public class Main {
   public static void main(String[] args) {
      Car car = new Car();

      // Field injection done manually
      car.engine = new PetrolEngine();
      car.startCar();

      System.out.println("-----");

      // Switch engine to Diesel
      car.engine = new DieselEngine();
      car.startCar();
   }
}
