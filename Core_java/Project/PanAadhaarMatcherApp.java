package Spark2_0.Project;

import java.util.Scanner;

public class PanAadhaarMatcherApp {
   public static void main(String[] args) {
      Scanner scanner=new Scanner(System.in);
      AadhaarService aadhaarService=new AadhaarService();
      PanService panService=new PanService();

      System.out.println("Enter Aadhaar Number");
      String aadhaarNumber= scanner.nextLine();

      Aadhaar aadhaar=aadhaarService.getAadhaarByNumber(aadhaarNumber);
      Pan pan=panService.getPanByAadhaarNumber(aadhaarNumber);

      if(aadhaar != null && pan != null){
         System.out.println("Pan Details"+ pan);
         System.out.println("Aadhaar Details"+ aadhaar);
      }
      else {
         System.out.println("No Match found....");
      }

   }
}
