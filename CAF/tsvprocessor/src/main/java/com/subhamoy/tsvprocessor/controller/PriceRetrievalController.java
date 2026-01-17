package com.subhamoy.tsvprocessor.controller;

import com.subhamoy.tsvprocessor.service.PriceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/price")
public class PriceRetrievalController {

   @Autowired
   private PriceService priceService;

   /**
    * Endpoint to retrieve price based on skuID and optional time
    * @param skuID The unique identifier for the product
    * @param time (Optional) The time for price filtering
    * @return The price or "NOT SET" if no price found
    */
   @GetMapping
   public String getPrice(@RequestParam String skuID, @RequestParam(required = false) String time) {
      try {
         return priceService.getPrice(skuID, time);
      } catch (Exception e) {
         return "Error retrieving price: " + e.getMessage();
      }
   }
}