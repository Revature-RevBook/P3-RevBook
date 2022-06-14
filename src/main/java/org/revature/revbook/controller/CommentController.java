package org.revature.revbook.controller;

import org.revature.revbook.entity.Comment;
import org.revature.revbook.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// CommentController Class
// This class will handle the HTTP Requests for the API/resource paths associated with the Comment objects.
@CrossOrigin(origins = "*")
@RestController
@RequestMapping(path = "/comments")
public class CommentController {

    @Autowired
    CommentService commentService;

    // PostMapping to add a Comment to the database:
    @PostMapping("")
    public Comment addComment(@RequestBody Comment comment) {
        return commentService.addComment(comment);
    }

    // GetMapping to retrieve a specific Comment object from the database:
    @GetMapping("/{commentId}")
    public Comment getCommentById(@PathVariable("commentId") Long commentId) {
        return commentService.getCommentById(commentId);
    }

    // GetMapping to retrieve Comment objects for a specified Post from the database:
    @GetMapping("/post/{postId}")
    public List<Comment> getAllCommentsByPostId(@PathVariable("postId") Long postId) {
        return commentService.getAllCommentsByPostId(postId);
    }

    // GetMapping to retrieve Comment objects from the database:
    @GetMapping("")
    public List<Comment> getAllComments() {
        return commentService.getAllComments();
    }

    // PutMapping to update a specified Comment record with the supplied JSON Comment object in the database:
    @PutMapping("/{commentId}")
    public Comment updateComment(@PathVariable("commentId") Long commentId, @RequestBody Comment comment) {
        return commentService.updateComment(comment, commentId);
    }

    // DeleteMapping to delete a specified Comment record from the database:
    @DeleteMapping("/{commentId}")
    public void deleteComment(@PathVariable("commentId") Long commentId) {
        commentService.deleteComment(commentId);
    }
}
