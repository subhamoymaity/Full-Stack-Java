package com.subhamoy.configparser.util;

import com.subhamoy.configparser.dto.ConfigDTO;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class ConfigParserUtil {

   private final Map<String, Map<String, List<String>>> sections = new HashMap<>();

   /**
    * Reads and parses the configuration file into an in-memory structure for efficient retrieval
    * @param filePath Location of the configuration file
    */
   public ConfigParserUtil(String filePath) {
      try {
         parseConfigFile(filePath);
      } catch (IOException e) {
         throw new RuntimeException("Failed to load config file", e);
      }
   }

   /**
    * Parses the configuration file into a Map structure
    * @param filePath Path to the configuration file
    */
   private void parseConfigFile(String filePath) throws IOException {
      String currentSection = null;

      try (BufferedReader reader = Files.newBufferedReader(Paths.get(filePath))) {
         String line;
         while ((line = reader.readLine()) != null) {
            // Skip empty lines
            line = line.trim();
            if (line.isEmpty()) continue;

            // Detect section header
            if (!line.contains("=")) {
               currentSection = line;
               sections.putIfAbsent(currentSection, new HashMap<>());
            } else if (currentSection != null) {
               // Detect key-value pairs
               String[] keyValue = line.split("=", 2);
               String key = keyValue[0].trim();
               String value = keyValue.length > 1 ? keyValue[1].trim() : "";

               // Handle multiple entries (comma-separated values)
               List<String> valueList = Arrays.asList(value.split(","));
               sections.get(currentSection).put(key, new ArrayList<>(valueList));
            }
         }
      }
   }

   /**
    * Converts a section to a ConfigDTO for returning JSON responses
    * @param sectionName Name of the section
    * @return ConfigDTO containing section details
    */
   public ConfigDTO getSectionAsDTO(String sectionName) {
      if (!sections.containsKey(sectionName)) {
         throw new IllegalArgumentException("Section '" + sectionName + "' not found.");
      }

      Map<String, List<String>> section = sections.get(sectionName);
      ConfigDTO dto = new ConfigDTO();
      dto.setBroker(getSingleValue(section, "broker"));
      dto.setTopic(getListValues(section, "topic"));
      return dto;
   }

   private String getSingleValue(Map<String, List<String>> section, String key) {
      return section.containsKey(key) && !section.get(key).isEmpty()
                    ? section.get(key).get(0)
                    : null;
   }

   private List<String> getListValues(Map<String, List<String>> section, String key) {
      return section.getOrDefault(key, Collections.emptyList());
   }
}