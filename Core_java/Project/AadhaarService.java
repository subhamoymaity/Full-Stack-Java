package Spark2_0.Project;

import java.util.HashMap;
import java.util.Map;

public class AadhaarService {
    private static Map<String,Aadhaar>aadhaarMap=new HashMap<>();
   static { // it will run in the time of class loading
      aadhaarMap.put("10700122009",new Aadhaar("10700122009","Subhamoy Maity","Balul Maity","123 road"));
      aadhaarMap.put("10700122008",new Aadhaar("10700122008","Subham Maity","Tapan Maity","133 road"));
   }
   public Aadhaar getAadhaarByNumber(String aadhaarNumber){
      return aadhaarMap.get(aadhaarNumber);
   }
}
