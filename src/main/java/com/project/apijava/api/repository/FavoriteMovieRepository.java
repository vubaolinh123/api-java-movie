package com.project.apijava.api.repository;

import com.project.apijava.api.model.FavoriteMovie;
import org.springframework.data.mongodb.repository.MongoRepository;
import java.util.List;

public interface FavoriteMovieRepository extends MongoRepository<FavoriteMovie, String>{
    boolean existsByUserIdAndMediaId(String userId, String mediaId);

    List<FavoriteMovie> findByUserIdAndMediaType(String userId, Number media_type);
}
