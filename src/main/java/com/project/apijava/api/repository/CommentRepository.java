package com.project.apijava.api.repository;

import com.project.apijava.api.model.Comment;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentRepository extends MongoRepository<Comment, String> {
//    Comment findAllByMovie_id(String movie_id);

}
