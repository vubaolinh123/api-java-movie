package com.project.apijava.api.repository;

import com.project.apijava.api.model.FavoriteMovie;
import org.springframework.data.mongodb.repository.MongoRepository;


public interface FavoriteMovieRepository extends MongoRepository<FavoriteMovie, String>{

}
