package looseCouple;

public class Main {
   public static void main(String[] args) {
      Engine petrol = new PetrolEngine(); // OR use new DieselEngine()
      Car car1 = new Car(petrol);
      car1.startCar();

      System.out.println("-----");

      Engine diesel = new DieselEngine();
      Car car2 = new Car(diesel);
      car2.startCar();
   }
}

