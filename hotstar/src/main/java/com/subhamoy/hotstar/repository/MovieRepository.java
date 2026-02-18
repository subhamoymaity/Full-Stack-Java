package com.subhamoy.hotstar.repository;

import com.subhamoy.hotstar.model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Long> {
   List<Movie> findByCategory(String category);
   List<Movie> findByTitleContainingIgnoreCase(String title);
}