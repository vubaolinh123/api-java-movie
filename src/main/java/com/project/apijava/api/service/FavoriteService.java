package com.project.apijava.api.service;

import com.project.apijava.api.model.FavoriteMovie;
import com.project.apijava.api.model.User;
import com.project.apijava.api.repository.FavoriteMovieRepository;
import com.project.apijava.api.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FavoriteService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private FavoriteMovieRepository favoriteMovieRepository;

    public FavoriteMovie addMedia(String userId, FavoriteMovie favoriteMovie) {
        User user = userRepository.findById(userId).orElseThrow(() -> new RuntimeException("User not found"));
        List<FavoriteMovie> existingFavorites = favoriteMovieRepository.findByUserIdAndMediaId(user, favoriteMovie.getMediaId());
        if (!existingFavorites.isEmpty()) {
            throw new RuntimeException("Phim đã có trong danh sách yêu thích");
        }
        favoriteMovie.setUserId(String.valueOf(user));
        return favoriteMovieRepository.save(favoriteMovie);
    }

    public FavoriteMovie removeMedia(String userId, String mediaId) {
        User user = userRepository.findById(userId).orElseThrow(() -> new RuntimeException("User not found"));
        FavoriteMovie favoriteMovie = favoriteMovieRepository.findByUserIdAndMediaIdAndDelete(user, mediaId);
        if (favoriteMovie == null) {
            throw new RuntimeException("Có lỗi xảy ra");
        }
        return favoriteMovie;
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