package com.subhamoy.configparser.dto;

import java.util.List;

public class ConfigDTO {
   private String broker;
   private List<String> topic;

   // Getters and setters
   public String getBroker() {
      return broker;
   }

   public void setBroker(String broker) {
      this.broker = broker;
   }

   public List<String> getTopic() {
      return topic;
   }

   public void setTopic(List<String> topic) {
      this.topic = topic;
   }
}