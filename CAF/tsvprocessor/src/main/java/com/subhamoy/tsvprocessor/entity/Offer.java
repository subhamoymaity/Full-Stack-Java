package com.subhamoy.tsvprocessor.entity;

import jakarta.persistence.*;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

@Entity
@Table(name = "offers")
public class Offer {

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private int id;

   @Column(name = "sku_id", nullable = false)
   private String skuID;

   @Column(name = "start_time", nullable = false)
   private String startTime;

   @Column(name = "end_time", nullable = false)
   private String endTime;

   @Column(name = "price", nullable = false)
   private int price;

   /**
    * Checks if the provided time falls within the offer's time range.
    * @param time The given time in "HH:mm" format
    * @return true if time is within range, otherwise false
    */
   public boolean isWithinTimeRange(String time) {
      LocalTime queryTime = LocalTime.parse(time, DateTimeFormatter.ofPattern("HH:mm"));
      LocalTime start = LocalTime.parse(startTime, DateTimeFormatter.ofPattern("HH:mm"));
      LocalTime end = LocalTime.parse(endTime, DateTimeFormatter.ofPattern("HH:mm"));

      return !queryTime.isBefore(start) && !queryTime.isAfter(end);
   }

   /**
    * Retrieves the price of the offer.
    * @return Price of the offer
    */
   public int getPrice() {
      return price;
   }

   // Getters and setters for all fields
   public int getId() {
      return id;
   }

   public void setId(int id) {
      this.id = id;
   }

   public String getSkuID() {
      return skuID;
   }

   public void setSkuID(String skuID) {
      this.skuID = skuID;
   }

   public String getStartTime() {
      return startTime;
   }

   public void setStartTime(String startTime) {
      this.startTime = startTime;
   }

   public String getEndTime() {
      return endTime;
   }

   public void setEndTime(String endTime) {
      this.endTime = endTime;
   }

   public void setPrice(int price) {
      this.price = price;
   }
}