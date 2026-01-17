package com.subhamoy.tsvprocessor.service;

import com.subhamoy.tsvprocessor.entity.Offer;
import com.subhamoy.tsvprocessor.repo.OfferRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PriceService {

   @Autowired
   private OfferRepository offerRepository;

   /**
    * Retrieves price by skuID with optional time filtering
    * @param skuID The unique identifier for the product
    * @param time (Optional) The time for price filtering
    * @return The price or "NOT SET"
    */
   public String getPrice(String skuID, String time) {
      List<Offer> offers = offerRepository.findBySkuID(skuID);

      // If no offers found for skuID
      if (offers.isEmpty()) {
         return "NOT SET";
      }

      // If time is provided, filter by time
      if (time != null) {
         for (Offer offer : offers) {
            if (offer.isWithinTimeRange(time)) {
               return String.valueOf(offer.getPrice());
            }
         }
         return "NOT SET"; // No matching time range
      }

      // If no time is provided, return the first offer's price
      return String.valueOf(offers.get(0).getPrice());
   }
}