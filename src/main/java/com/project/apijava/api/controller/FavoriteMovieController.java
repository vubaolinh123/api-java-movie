package com.project.apijava.api.controller;

import com.project.apijava.api.model.FavoriteMovie;
import com.project.apijava.api.service.FavoriteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/favoriteMovie")
public class FavoriteMovieController {
    @Autowired
    private FavoriteService favoriteService;

    @PostMapping
    public ResponseEntity<FavoriteMovie> addFavoriteMovie(@RequestBody FavoriteMovie movie) {
        FavoriteMovie saveMovie = favoriteService.saveFavoriteMovie(movie);
        return ResponseEntity.ok(saveMovie);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable String id) {
        if (favoriteService.getFavoriteMovieById(id).isPresent()) {
            favoriteService.deleteFavoriteMovie(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}
