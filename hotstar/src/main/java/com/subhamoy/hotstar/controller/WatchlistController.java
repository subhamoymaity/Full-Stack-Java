package com.subhamoy.hotstar.controller;

import com.subhamoy.hotstar.model.Movie;
import com.subhamoy.hotstar.service.WatchlistService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/watchlist")
public class WatchlistController {

   private final WatchlistService watchlistService;

   public WatchlistController(WatchlistService watchlistService) {
      this.watchlistService = watchlistService;
   }

   @GetMapping
   public ResponseEntity<List<Movie>> getWatchlist(Authentication authentication) {
      String email = authentication.getName();
      return ResponseEntity.ok(watchlistService.getUserWatchlist(email));
   }

   @PostMapping("/{movieId}")
   public ResponseEntity<String> addToWatchlist(Authentication authentication, @PathVariable Long movieId) {
      String email = authentication.getName();
      watchlistService.addToWatchlist(email, movieId);
      return ResponseEntity.ok("Added to watchlist");
   }

   @DeleteMapping("/{movieId}")
   public ResponseEntity<String> removeFromWatchlist(Authentication authentication, @PathVariable Long movieId) {
      String email = authentication.getName();
      watchlistService.removeFromWatchlist(email, movieId);
      return ResponseEntity.ok("Removed from watchlist");
   }
}