package com.subhamoy.hotstar.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfig implements WebMvcConfigurer {
   @Override
   public void addCorsMappings(CorsRegistry registry) {
      registry.addMapping("/api/**")
             .allowedOrigins(
                    "http://localhost:3000",     // React default
                    "http://localhost:5173",     // Vite default ← ADD THIS
                    "http://localhost:5174"      // Vite alternative
             )
             .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS")
             .allowedHeaders("*")
             .allowCredentials(true)
             .maxAge(3600);
   }
}