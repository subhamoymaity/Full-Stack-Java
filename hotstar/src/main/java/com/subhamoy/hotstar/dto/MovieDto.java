package com.subhamoy.hotstar.dto;

import lombok.Data;

@Data
public class MovieDto {
   private Long id;
   private String title;
   private String year;
   private String poster;
   private String category;
   private String youtubeUrl;
   private String description;

}