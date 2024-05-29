package com.project.apijava.api.controller;

import com.project.apijava.api.model.Comment;
import com.project.apijava.api.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/comments")
@CrossOrigin(origins = "http://localhost:3000")

public class CommentController {
    @Autowired
    private CommentService commentService;

    @PostMapping
    public ResponseEntity<Comment> createComment(@RequestBody Comment comment) {
        Comment saveComment = commentService.saveComment(comment, comment.getUser().getId());
        return ResponseEntity.ok(saveComment);
    }

    @PutMapping
    public ResponseEntity<Comment> replyComment(@RequestBody Comment comment) {
        Comment saveComment = commentService.replyComment(comment);
        return ResponseEntity.ok(saveComment);
    }

    @GetMapping
    public List<Comment> getAllComments() {
        return commentService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Comment> getCommentById(@PathVariable String id) {
        Optional<Comment> comment = commentService.findById(id);
        return comment.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/{id}/video")
    public ResponseEntity<List<Comment>> getCommentByIdFilm(@PathVariable String id) {
        List<Comment> commentList = commentService.findCommentsByMovieId(id);
        System.out.println("commentText: " +commentList.stream().findAny().toString());
        if (commentList != null) {
            return ResponseEntity.ok(commentList);  // Trả về danh sách các comment nếu tồn tại
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND); // Trả về mã trạng thái NOT_FOUND nếu không tìm thấy comment
        }
    }


}
