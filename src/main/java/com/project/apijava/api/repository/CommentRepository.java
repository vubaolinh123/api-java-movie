package com.project.apijava.api.repository;

import com.project.apijava.api.model.Comment;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentRepository extends MongoRepository<Comment, String> {
    List<Comment> getCommentsByMovieId(String movieId);

}
