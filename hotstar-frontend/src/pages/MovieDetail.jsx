import React, { useState, useEffect, useContext } from 'react';
import { useParams, useNavigate } from 'react-router-dom';
import { getMovieById, addToWatchlist, removeFromWatchlist } from '../services/api';
import { AuthContext } from '../context/AuthContext';

function MovieDetail() {
  const { id } = useParams();
  const { user } = useContext(AuthContext);
  const navigate = useNavigate();
  const [movie, setMovie] = useState(null);
  const [loading, setLoading] = useState(true);
  const [error, setError] = useState('');
  const [inWatchlist, setInWatchlist] = useState(false);

  useEffect(() => {
    fetchMovie();
  }, [id]);

  const fetchMovie = async () => {
    try {
      const response = await getMovieById(id);
      setMovie(response.data);
    } catch (err) {
      setError('Failed to fetch movie details');
    } finally {
      setLoading(false);
    }
  };

  const handleAddToWatchlist = async () => {
    if (!user) {
      navigate('/login');
      return;
    }

    try {
      await addToWatchlist(id);
      setInWatchlist(true);
      alert('Added to watchlist!');
    } catch (err) {
      alert(err.response?.data?.message || 'Failed to add to watchlist');
    }
  };

  const handleRemoveFromWatchlist = async () => {
    try {
      await removeFromWatchlist(id);
      setInWatchlist(false);
      alert('Removed from watchlist!');
    } catch (err) {
      alert('Failed to remove from watchlist');
    }
  };

  if (loading) {
    return (
      <div className="container text-center mt-5">
        <div className="spinner-border text-primary" role="status"></div>
      </div>
    );
  }

  if (error || !movie) {
    return (
      <div className="container mt-5">
        <div className="alert alert-danger">{error || 'Movie not found'}</div>
      </div>
    );
  }

  return (
    <div className="container mt-4">
      <div className="row">
        <div className="col-md-4">
          <img
            src={movie.poster || 'https://via.placeholder.com/300x450'}
            alt={movie.title}
            className="img-fluid rounded"
          />
        </div>
        <div className="col-md-8">
          <h1>{movie.title}</h1>
          <p className="text-muted">
            <strong>Year:</strong> {movie.year} | <strong>Category:</strong> {movie.category}
          </p>
          <p>{movie.description}</p>
          
          <div className="mt-4">
            {user && (
              <>
                {inWatchlist ? (
                  <button className="btn btn-danger me-2" onClick={handleRemoveFromWatchlist}>
                    Remove from Watchlist
                  </button>
                ) : (
                  <button className="btn btn-success me-2" onClick={handleAddToWatchlist}>
                    Add to Watchlist
                  </button>
                )}
              </>
            )}
            
            {movie.youtubeUrl && (
              <a href={movie.youtubeUrl} target="_blank" rel="noreferrer" className="btn btn-primary">
                Watch Trailer
              </a>
            )}
          </div>
        </div>
      </div>
    </div>
  );
}

export default MovieDetail;