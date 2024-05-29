package com.project.apijava.api.service;

import com.project.apijava.api.model.FavoriteMovie;
import com.project.apijava.api.repository.FavoriteMovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class FavoriteService {
    @Autowired
    private FavoriteMovieRepository favoriteMovieRepository;

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