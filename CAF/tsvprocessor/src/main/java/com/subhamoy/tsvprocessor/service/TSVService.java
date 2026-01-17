package com.subhamoy.tsvprocessor.service;

import com.subhamoy.tsvprocessor.entity.Offer;
import com.subhamoy.tsvprocessor.repo.OfferRepository;
import com.subhamoy.tsvprocessor.util.TSVParserUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Service
public class TSVService {

   @Autowired
   private OfferRepository offerRepository;

   @Autowired
   private TSVParserUtil tsvParserUtil;

   /**
    * Processes the uploaded TSV file and saves its entries to the database
    * @param file The TSV file
    */
   public void processTSVFile(MultipartFile file) throws Exception {
      List<Offer> offers = tsvParserUtil.parseTSV(file);
      offerRepository.saveAll(offers); // Persist entries in the database
   }
}
