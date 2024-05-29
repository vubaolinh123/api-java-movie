package com.project.apijava.api.service;

import com.project.apijava.api.model.FavoriteMovie;
import com.project.apijava.api.model.Product;
import com.project.apijava.api.repository.FavoriteMovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.List;
@Service
public class FavoriteMovieService {
    @Autowired
    private FavoriteMovieRepository favoriteMovieRepository;

    public boolean isMovieFavorited(String userId, String mediaId) {
        return favoriteMovieRepository.existsByUserIdAndMediaId(userId, mediaId);
    }

    public List<FavoriteMovie> findByMovie(String userId) {
        return favoriteMovieRepository.findByUserIdAndMediaType(userId, 0);
    }

    public List<FavoriteMovie> findByTV(String userId) {
        return favoriteMovieRepository.findByUserIdAndMediaType(userId, 1);
    }

    public FavoriteMovie saveFavoriteMovie(FavoriteMovie movie) {
        return favoriteMovieRepository.save(movie);
    }

    public Optional<FavoriteMovie> getFavoriteMovieById(String id) {
        return favoriteMovieRepository.findById(id);
    }

    public void deleteFavoriteMovie(String id) {
        favoriteMovieRepository.deleteById(id);
    }
}