package com.project.apijava.api.controller;

import com.project.apijava.api.model.Comment;
import com.project.apijava.api.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/comments")

public class CommentController {
    @Autowired
    private CommentService commentService;

    @PostMapping
    public ResponseEntity<Comment> addComment(@RequestBody Comment comment) {
        Comment saveComment = commentService.addComment(comment);
        return ResponseEntity.ok(saveComment);
    }

    @GetMapping
    public List<Comment> getAllComments() {
        return commentService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Comment> getCommentById(@PathVariable String id) {
        Optional<Comment> comment = commentService.findAllByMovie_id(id);
        return comment.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/{id}/video")
    public ResponseEntity<Comment> getCommentByIdFilm(@PathVariable String id) {
        Optional<Comment> comment = commentService.findAllByMovie_id(id);
        return comment.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

}
