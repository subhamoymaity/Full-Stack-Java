package com.subhamoy.configparser.controller;

import com.subhamoy.configparser.service.ConfigService;
import com.subhamoy.configparser.dto.ConfigDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/config")
public class ConfigController {

   @Autowired
   private ConfigService configService;

   /**
    * API to get section details as JSON based on section name
    * @param sectionName name of the section from the config file
    * @return Config details in JSON format
    */
   @GetMapping
   public ConfigDTO getConfigBySection(@RequestParam String sectionName) {
      return configService.getSectionDetails(sectionName);
   }
}