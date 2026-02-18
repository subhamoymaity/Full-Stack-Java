import React, { useState, useEffect } from 'react';
import { useSearchParams } from 'react-router-dom';
import { getAllMovies, searchMovies, getMoviesByCategory } from '../services/api';
import MovieCard from '../components/MovieCard';

function Home() {
  const [movies, setMovies] = useState([]);
  const [loading, setLoading] = useState(true);
  const [error, setError] = useState('');
  const [selectedCategory, setSelectedCategory] = useState('All');
  const [searchParams] = useSearchParams();

  const categories = ['All', 'Action', 'Comedy', 'Drama', 'Horror', 'Sci-Fi', 'Romance'];

  useEffect(() => {
    fetchMovies();
  }, [searchParams, selectedCategory]);

  const fetchMovies = async () => {
    setLoading(true);
    setError('');

    try {
      const searchQuery = searchParams.get('search');
      let response;

      if (searchQuery) {
        response = await searchMovies(searchQuery);
      } else if (selectedCategory === 'All') {
        response = await getAllMovies();
      } else {
        response = await getMoviesByCategory(selectedCategory);
      }

      setMovies(response.data);
    } catch (err) {
      setError('Failed to fetch movies. Please try again.');
      console.error(err);
    } finally {
      setLoading(false);
    }
  };

  if (loading) {
    return (
      <div className="container text-center mt-5">
        <div className="spinner-border text-primary" role="status">
          <span className="visually-hidden">Loading...</span>
        </div>
      </div>
    );
  }

  return (
    <div className="container mt-4">
      <h2 className="mb-4">Browse Movies</h2>

      {/* Category Filter */}
      <div className="mb-4">
        <div className="btn-group" role="group">
          {categories.map((category) => (
            <button
              key={category}
              type="button"
              className={`btn ${selectedCategory === category ? 'btn-primary' : 'btn-outline-primary'}`}
              onClick={() => setSelectedCategory(category)}
            >
              {category}
            </button>
          ))}
        </div>
      </div>

      {/* Show ONLY ONE message */}
      {error ? (
        <div className="alert alert-danger" role="alert">
          {error}
        </div>
      ) : movies.length === 0 ? (
        <div className="alert alert-info" role="alert">
          No movies found. Please add some movies to the database.
        </div>
      ) : (
        <div className="row">
          {movies.map((movie) => (
            <MovieCard key={movie.id} movie={movie} />
          ))}
        </div>
      )}
    </div>
  );
}

export default Home;