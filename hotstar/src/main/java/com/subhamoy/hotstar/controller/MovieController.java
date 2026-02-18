package com.subhamoy.hotstar.controller;

import com.subhamoy.hotstar.model.Movie;
import com.subhamoy.hotstar.service.MovieService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/movies")
public class MovieController {

   private final MovieService movieService;

   public MovieController(MovieService movieService) {
      this.movieService = movieService;
   }

   @GetMapping("/all")
   public ResponseEntity<List<Movie>> getAllMovies() {
      return ResponseEntity.ok(movieService.getAllMovies());
   }

   @GetMapping("/category/{category}")
   public ResponseEntity<List<Movie>> getMoviesByCategory(@PathVariable String category) {
      return ResponseEntity.ok(movieService.getMoviesByCategory(category));
   }

   @GetMapping("/search")
   public ResponseEntity<List<Movie>> searchMovies(@RequestParam String query) {
      return ResponseEntity.ok(movieService.searchMovies(query));
   }

   @GetMapping("/{id}")
   public ResponseEntity<Movie> getMovieById(@PathVariable Long id) {
      return ResponseEntity.ok(movieService.getMovieById(id));
   }
}