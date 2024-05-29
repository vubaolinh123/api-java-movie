package com.project.apijava.api.controller;

import com.project.apijava.api.model.FavoriteMovie;
import com.project.apijava.api.service.FavoriteMovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/favorite")
public class FavoriteMovieController {
    @Autowired
    private FavoriteMovieService favoriteService;

    @CrossOrigin(origins = "http://localhost:3000", allowCredentials = "true")
    @PostMapping
    public ResponseEntity<FavoriteMovie> addFavoriteMovie(@RequestBody FavoriteMovie movie) {
        System.out.println("getMediaType" + movie.getMediaType());
//        if(!favoriteService.isMovieFavorited(movie.getUserId(),movie.getMediaId())){
//        if(favoriteService.isMovieFavorited(movie.getUserId(), movie.getMediaId())){
////            return ResponseEntity.badRequest().build();
////            System.out.println("vãi cả nồi: " + movie);
//            FavoriteMovie saveMovie = favoriteService.saveFavoriteMovie(movie);
//            return ResponseEntity.ok(saveMovie);
//        }
        FavoriteMovie saveMovie = favoriteService.saveFavoriteMovie(movie);
        return ResponseEntity.ok(saveMovie);
    }

    @CrossOrigin(origins = "http://localhost:3000", allowCredentials = "true")
    @GetMapping("/movie/{user_id}")
    public List<FavoriteMovie> listFavoriteMovie(@PathVariable String user_id) {
        return favoriteService.findByMovie(user_id);
    }

    @CrossOrigin(origins = "http://localhost:3000", allowCredentials = "true")
    @GetMapping("/tv/{user_id}")
    public List<FavoriteMovie> listFavoriteTV(@PathVariable String user_id) {
        return favoriteService.findByTV(user_id);
    }

    @CrossOrigin(origins = "http://localhost:3000", allowCredentials = "true")
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
