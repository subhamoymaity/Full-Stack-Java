package Spark2_0.Project;

public class Aadhaar {
   private String aadhaarNumber;
   private String name;
   private String fatherMame;
   private String address;

   //we create constructor -> when we want , when we will create object of Aadhaar  class , we can set or initialize the value
   public Aadhaar(String aadhaarNumber, String name, String fatherMame, String address) {
      this.aadhaarNumber = aadhaarNumber;
      this.name = name;
      this.fatherMame = fatherMame;
      this.address = address;
   }
// For accessing privet member we use getter & setter
   public String getAadhaarNumber() {
      return aadhaarNumber;
   }
   public void setAadhaarNumber(String aadhaarNumber) {
      this.aadhaarNumber = aadhaarNumber;
   }
   public String getName() {
      return name;
   }
   public void setName(String name) {
      this.name = name;
   }
   public String getFatherMame() {
      return fatherMame;
   }
   public void setFatherMame(String fatherMame) {
      this.fatherMame = fatherMame;
   }
   public String getAddress() {
      return address;
   }
   public void setAddress(String address) {
      this.address = address;
   }

   @Override
   public String toString() {
      return "Aadhaar{" +
                    "aadhaarNumber='" + aadhaarNumber + '\'' +
                    ", name='" + name + '\'' +
                    ", fatherMame='" + fatherMame + '\'' +
                    ", address='" + address + '\'' +
                    '}';
   }

}
