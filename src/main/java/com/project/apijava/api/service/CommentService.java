package com.project.apijava.api.service;

import com.project.apijava.api.model.Comment;
import com.project.apijava.api.repository.CommentRepository;
import com.project.apijava.api.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CommentService {
    @Autowired
    private CommentRepository commentRepository;

    @Autowired
    private UserRepository userRepository;

    public Comment addComment(Comment comment) {
        Optional<User> userOptional = userRepository.findById(comment.getUser().getId());
        if (userOptional.isPresent()) {
            comment.setUser(userOptional.get());
            return commentRepository.save(comment);
        } else {
            throw new RuntimeException("User not found");
        }
    }

//    public Comment saveComment(Comment comment) {
//        return commentRepository.save(comment);
//    }

    public List<Comment> findAll() {
        return commentRepository.findAll();
    }

    public List<Comment> findCommentsByMovieId(String id) {
        return commentRepository.getCommentsByMovieId(id);
    }

    public Optional<Comment> findById(String id) {
        return commentRepository.findById(id);
    }
}
