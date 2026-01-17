package com.Subhamoy.SpringBootP02.config;

import com.Subhamoy.SpringBootP02.beans.Reels;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
// we create predefined class bean
import java.time.LocalDateTime;

/*
@Component   this is parent , that's not good practice
Without @Configuration, your @Bean methods may not behave as singletons!
@Component won't do this proxying — so calling one @Bean method inside another can create multiple objects!
 */


@Configuration
public class InstaConfig {
   @Bean
   public LocalDateTime getInstance() {
      return LocalDateTime.now();
   }
   // we can also create custom class bean but tis not best practice
//   @Bean
//   public Reels getObject(){
//      return new Reels();
//   }
}
