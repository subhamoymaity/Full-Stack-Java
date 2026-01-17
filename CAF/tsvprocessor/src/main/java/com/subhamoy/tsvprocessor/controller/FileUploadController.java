package com.subhamoy.tsvprocessor.controller;

import com.subhamoy.tsvprocessor.service.TSVService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/api/upload")
public class FileUploadController {

   @Autowired
   private TSVService tsvService;

   /**
    * Endpoint to upload TSV file
    * @param file The TSV file as MultipartFile
    * @return Message indicating success or failure
    */
   @PostMapping
   public String uploadTSVFile(@RequestParam("file") MultipartFile file) {
      try {
         tsvService.processTSVFile(file);
         return "TSV file uploaded and processed successfully!";
      } catch (Exception e) {
         return "Error processing TSV file: " + e.getMessage();
      }
   }
}
