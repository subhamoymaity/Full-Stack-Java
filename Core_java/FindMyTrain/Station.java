package Spark2_0.FindMyTrain;

import java.util.ArrayList;
import java.util.List;

public class Station {
   private String stationID;
   private String stationName;
   private List<Platform> platformList;

   public Station(String stationID, String stationName) {
      this.stationID = stationID;
      this.stationName = stationName;
      this.platformList=new ArrayList<>(); // when platform will available then put it into
   }

   public String getStationID() {
      return stationID;
   }

   public void setStationID(String stationID) {
      this.stationID = stationID;
   }

   public String getStationName() {
      return stationName;
   }

   public void setStationName(String stationName) {
      this.stationName = stationName;
   }

   public List<Platform> getPlatformList() {
      return platformList;
   }

   public void setPlatformList(List<Platform> platformList) {
      this.platformList = platformList;
   }

   @Override
   public String toString() {
      return "Station{" +
                    "stationID='" + stationID + '\'' +
                    ", stationName='" + stationName + '\'' +
                    ", platformList=" + platformList +
                    '}';
   }
}
