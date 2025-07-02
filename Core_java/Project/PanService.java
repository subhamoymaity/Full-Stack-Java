package Spark2_0.Project;

import java.util.HashMap;
import java.util.Map;

public class PanService {
   private static Map<String,Pan>panMap=new HashMap<>();
   static {
      panMap.put("EDWAABC123M9",new Pan("EDWAABC123M9","10700122009","INDIAN Bank","Stock,ELSS,FD"));
      panMap.put("EDWAABC123M8",new Pan("EDWAABC123M8","10700122008","HDFC Bank","Stock,FD"));
   }
   public Pan getPanByAadhaarNumber(String aadhaarNumber){
      for (Pan pan:panMap.values()){
         if(pan.getAadhaarNumber().equals(aadhaarNumber)){
            return pan;
         }
      }
      return null;
   }
}
