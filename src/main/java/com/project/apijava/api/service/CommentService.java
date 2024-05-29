package com.project.apijava.api.service;

import com.project.apijava.api.model.Comment;
import com.project.apijava.api.model.User;
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

    public Comment addComment(String userId, String movieId, String desc, String type) {
        Optional<User> userOptional = userRepository.findById(userId);
        if (userOptional.isPresent()) {
            Comment comment = new Comment();
            comment.setUser(userOptional.get());
            comment.setMovie_id(movieId);
            comment.setDesc(desc);
            comment.setType(type);
            return commentRepository.save(comment);
        } else {
            throw new RuntimeException("User not found");
        }
    }

    public Comment saveComment(Comment comment) {
        return commentRepository.save(comment);
    }

    public List<Comment> findAll() {
        return commentRepository.findAll();
    }

    public Optional<Comment> findAllByMovie_id(String id) {
        return commentRepository.findById(id);
    }

//    public Comment findByIdFile(String id) {
//        return commentRepository.findById(id);;
//    }
}
