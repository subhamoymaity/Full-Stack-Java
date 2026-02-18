package com.subhamoy.hotstar.service;

import com.subhamoy.hotstar.model.Movie;
import com.subhamoy.hotstar.repository.MovieRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieService {

   private final MovieRepository movieRepository;

   public MovieService(MovieRepository movieRepository) {
      this.movieRepository = movieRepository;
   }

   public List<Movie> getAllMovies() {
      return movieRepository.findAll();
   }

   public List<Movie> getMoviesByCategory(String category) {
      return movieRepository.findByCategory(category);
   }

   public List<Movie> searchMovies(String query) {
      return movieRepository.findByTitleContainingIgnoreCase(query);
   }

   public Movie getMovieById(Long id) {
      return movieRepository.findById(id)
                    .orElseThrow(() -> new RuntimeException("Movie not found"));
   }
}