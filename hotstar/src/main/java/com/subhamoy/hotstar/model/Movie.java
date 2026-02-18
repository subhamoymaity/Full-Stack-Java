package com.subhamoy.hotstar.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "movies")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Movie {

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;

   private String title;
   private String year;
   private String poster;
   private String category; // movie, series, documentary
   private String youtubeUrl; // YouTube video URL or embed ID

   @Column(length = 1000)
   private String description;
}