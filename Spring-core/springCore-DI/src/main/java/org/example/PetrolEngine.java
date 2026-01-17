package org.example;

public class PetrolEngine implements IEngine{

   public PetrolEngine() {
      System.out.println("Petrol engine constructor");
   }

   public int start(){
      System.out.println("Petrol engine started ");
      return 1;
   }
}
