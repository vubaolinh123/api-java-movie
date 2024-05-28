package com.project.apijava.api.service;

import com.project.apijava.api.model.Comment;
import com.project.apijava.api.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CommentService {
    @Autowired
    private CommentRepository commentRepository;

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
