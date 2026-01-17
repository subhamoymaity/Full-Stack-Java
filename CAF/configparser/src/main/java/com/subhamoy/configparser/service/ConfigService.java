package com.subhamoy.configparser.service;

import com.subhamoy.configparser.dto.ConfigDTO;
import com.subhamoy.configparser.util.ConfigParserUtil;
import org.springframework.stereotype.Service;

@Service
public class ConfigService {

   private final ConfigParserUtil configParserUtil;

   public ConfigService() {
      // Load and parse the file when service is initialized
      configParserUtil = new ConfigParserUtil("src/main/resources/configFile.txt");
   }

   /**
    * Retrieves section details from the parsed config file
    * @param sectionName name of the section (e.g., "Order Service")
    * @return Config details in DTO format
    */
   public ConfigDTO getSectionDetails(String sectionName) {
      return configParserUtil.getSectionAsDTO(sectionName);
   }
}