package com.subhamoy.configparser;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Main Application Class
 */
@SpringBootApplication
public class ConfigParserApplication {

   public static void main(String[] args) {
      SpringApplication.run(ConfigParserApplication.class, args);
   }
}

//http://localhost:8080/api/config?sectionName=Order Service