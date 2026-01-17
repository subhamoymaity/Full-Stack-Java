package looseCouple;

public class Car {
   private Engine engine;

   // Constructor Injection (for loose coupling)
   public Car(Engine engine) {
      this.engine = engine;
   }

   public void startCar() {
      System.out.println("Starting the car...");
      engine.start(); // engine can be any type that implements Engine
   }
}

