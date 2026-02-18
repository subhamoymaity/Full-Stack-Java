package com.subhamoy.hotstar.service;

import com.subhamoy.hotstar.model.Movie;
import com.subhamoy.hotstar.model.User;
import com.subhamoy.hotstar.model.Watchlist;
import com.subhamoy.hotstar.repository.MovieRepository;
import com.subhamoy.hotstar.repository.UserRepository;
import com.subhamoy.hotstar.repository.WatchlistRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class WatchlistService {

   private final WatchlistRepository watchlistRepository;
   private final UserRepository userRepository;
   private final MovieRepository movieRepository;

   public WatchlistService(WatchlistRepository watchlistRepository,
                           UserRepository userRepository,
                           MovieRepository movieRepository) {
      this.watchlistRepository = watchlistRepository;
      this.userRepository = userRepository;
      this.movieRepository = movieRepository;
   }

   public List<Movie> getUserWatchlist(String email) {
      User user = userRepository.findByEmail(email)
                         .orElseThrow(() -> new RuntimeException("User not found"));

      return watchlistRepository.findByUserId(user.getId())
                    .stream()
                    .map(Watchlist::getMovie)
                    .collect(Collectors.toList());
   }

   public void addToWatchlist(String email, Long movieId) {
      User user = userRepository.findByEmail(email)
                         .orElseThrow(() -> new RuntimeException("User not found"));
      Movie movie = movieRepository.findById(movieId)
                           .orElseThrow(() -> new RuntimeException("Movie not found"));

      if (watchlistRepository.findByUserIdAndMovieId(user.getId(), movieId).isPresent()) {
         throw new RuntimeException("Movie already in watchlist");
      }

      Watchlist watchlist = new Watchlist();
      watchlist.setUser(user);
      watchlist.setMovie(movie);
      watchlistRepository.save(watchlist);
   }

   @Transactional
   public void removeFromWatchlist(String email, Long movieId) {
      User user = userRepository.findByEmail(email)
                         .orElseThrow(() -> new RuntimeException("User not found"));

      watchlistRepository.deleteByUserIdAndMovieId(user.getId(), movieId);
   }
}
