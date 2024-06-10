package com.project.apijava.api.controller;

import com.project.apijava.api.model.FavoriteMovie;
import com.project.apijava.api.service.FavoriteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class FavoriteController {

    @Autowired
    private FavoriteService favoriteService;

    @PostMapping("/favorites")
    public ResponseEntity<FavoriteMovie> addMedia(@RequestBody FavoriteMovie favoriteMovie) {
        try {
            FavoriteMovie addedFavorite = favoriteService.addMedia(favoriteMovie.getUserId(), favoriteMovie);
            return ResponseEntity.ok(addedFavorite);
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(null);
        }
    }

    @DeleteMapping("/users/{userId}/favorites/{mediaId}")
    public ResponseEntity<FavoriteMovie> removeMedia(@PathVariable String userId, @PathVariable String mediaId) {
        try {
            FavoriteMovie removedFavorite = favoriteService.removeMedia(userId, mediaId);
            return ResponseEntity.ok(removedFavorite);
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(null);
        }
    }

    @GetMapping("/users/{userId}/favorite-movies")
    public ResponseEntity<List<FavoriteMovie>> getFavoriteMovies(@PathVariable String userId) {
        List<FavoriteMovie> favoriteMovies = favoriteService.getFavoriteMovies(userId);
        return ResponseEntity.ok(favoriteMovies);
    }

    @GetMapping("/users/{userId}/favorite-tv")
    public ResponseEntity<List<FavoriteMovie>> getFavoriteTvShows(@PathVariable String userId) {
        List<FavoriteMovie> favoriteTvShows = favoriteService.getFavoriteTvShows(userId);
        return ResponseEntity.ok(favoriteTvShows);
    }
}
