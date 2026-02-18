import React from 'react';
import { Link } from 'react-router-dom';

function MovieCard({ movie }) {
  return (
    <div className="col-md-3 col-sm-6 mb-4">
      <div className="card h-100 bg-dark text-white" style={{ border: '1px solid #1f2937' }}>
        <img
          src={movie.poster || 'https://via.placeholder.com/300x450?text=No+Image'}
          className="card-img-top"
          alt={movie.title}
          style={{ height: '350px', objectFit: 'cover' }}
        />
        <div className="card-body">
          <h5 className="card-title">{movie.title}</h5>
          <p className="card-text">
            <small className="text-muted">{movie.year}</small>
            <span className="badge bg-primary ms-2">{movie.category}</span>
          </p>
          <Link to={`/movie/${movie.id}`} className="btn btn-sm btn-primary w-100">
            View Details
          </Link>
        </div>
      </div>
    </div>
  );
}

export default MovieCard;