import axios from 'axios';

const API_BASE_URL = 'http://localhost:8080/api';

const api = axios.create({
  baseURL: API_BASE_URL,
  headers: {
    'Content-Type': 'application/json',
  },
});

// Add token to requests if available
api.interceptors.request.use(
  (config) => {
    const token = localStorage.getItem('token');
    if (token) {
      config.headers.Authorization = `Bearer ${token}`;
    }
    return config;
  },
  (error) => {
    return Promise.reject(error);
  }
);

// Auth APIs
export const register = (userData) => api.post('/auth/register', userData);
export const login = (credentials) => api.post('/auth/login', credentials);

// Movie APIs (Public)
export const getAllMovies = () => api.get('/movies/all');
export const getMovieById = (id) => api.get(`/movies/${id}`);
export const getMoviesByCategory = (category) => api.get(`/movies/category/${category}`);
export const searchMovies = (query) => api.get(`/movies/search?query=${query}`);

// Watchlist APIs (Protected)
export const getWatchlist = () => api.get('/watchlist');
export const addToWatchlist = (movieId) => api.post(`/watchlist/${movieId}`);
export const removeFromWatchlist = (movieId) => api.delete(`/watchlist/${movieId}`);

export default api;