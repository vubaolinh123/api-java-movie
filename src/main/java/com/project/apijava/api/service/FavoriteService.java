package com.project.apijava.api.service;

import com.project.apijava.api.model.FavoriteMovie;
import com.project.apijava.api.model.User;
import com.project.apijava.api.repository.FavoriteMovieRepository;
import com.project.apijava.api.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FavoriteService {

    @Autowired
    private UserRepository userRepository;

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

    public List<FavoriteMovie> getFavoriteMovies(String userId) {
        User user = userRepository.findById(userId).orElseThrow(() -> new RuntimeException("User not found"));
        return favoriteMovieRepository.findByUserIdAndMediaType(user, 0);
    }

    public List<FavoriteMovie> getFavoriteTvShows(String userId) {
        User user = userRepository.findById(userId).orElseThrow(() -> new RuntimeException("User not found"));
        return favoriteMovieRepository.findByUserIdAndMediaType(user, 1);
    }
}