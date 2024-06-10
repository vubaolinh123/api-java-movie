package com.project.apijava.api.repository;

import com.project.apijava.api.model.FavoriteMovie;
import com.project.apijava.api.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FavoriteMovieRepository extends MongoRepository<FavoriteMovie, String> {
    List<FavoriteMovie> findByUserIdAndMediaId(User userId, String mediaId);
    List<FavoriteMovie> findByUserIdAndMediaType(User userId, int mediaType);
    FavoriteMovie findByUserIdAndMediaIdAndDelete(User userId, String mediaId);
}
