package com.subhamoy.tsvprocessor.util;

import com.subhamoy.tsvprocessor.entity.Offer;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

@Component
public class TSVParserUtil {

   /**
    * Parses a TSV file and converts the data to Offer entities
    * @param file The TSV file
    * @return List of offers
    */
   public List<Offer> parseTSV(MultipartFile file) throws Exception {
      List<Offer> offers = new ArrayList<>();

      try (BufferedReader reader = new BufferedReader(new InputStreamReader(file.getInputStream()))) {
         String line;

         // Skip header line
         reader.readLine();

         while ((line = reader.readLine()) != null) {
            String[] parts = line.split("\\|");
            Offer offer = new Offer();
            offer.setSkuID(parts[0].trim());
            offer.setStartTime(parts[1].trim());
            offer.setEndTime(parts[2].trim());
            offer.setPrice(Integer.parseInt(parts[3].trim()));

            offers.add(offer);
         }
      }

      return offers;
   }
}