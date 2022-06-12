package org.revature.revbook.service;

import org.revature.revbook.data.CommentRepository;
import org.revature.revbook.entity.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

// CommentService Class
// This class will handle the business logic for the Comment objects in the application.
@Service
public class CommentService {

    @Autowired
    CommentRepository commentRepository;

    // AddComment method
    // This method will insert a new Comment object into the database as a record:
    public Comment addComment(Comment comment){
        // Add the current time to the createdAt for comment:
        comment.setCreatedAt(Timestamp.valueOf(LocalDateTime.now()));

        // Call CommentRepository to save the modified comment:
        commentRepository.save(comment);
        return comment;
    }

    // GetAllComments method
    // This method will retrieve the List of Comment objects from the database:
    public List<Comment> getAllComments(){
        return commentRepository.findAll();
    }

    // GetCommentById method
    // This method will get a specific Comment object from the database with the supplied id:
    public Comment getCommentById(Long commentId) {
        return commentRepository.findById(commentId).get();
    }

    // GetAllCommentsByPost method
    // This method will retrieve List of Comments from the database by calling the CommentRepository and using the
    //  findByPostId method which will supply the postId to the method:
    public List<Comment> getAllCommentsByPostId(Long postId) {
        return commentRepository.findByPostId(postId);
    }

    // UpdateComment method
    // This method will update a record in the database by the specified id:
    public Comment updateComment(Comment comment, Long commentId) {
        // Retrieve the database Comment object from the database that matches the id:
        Comment commentDB = commentRepository.findById(commentId).get();

        // Set the database Comment's attributes to the supplied Comment object's attributes:
        commentDB.setUpdatedAt(Timestamp.valueOf(LocalDateTime.now()));
        commentDB.setCommentContent(comment.getCommentContent());

        // Update the record in the database through the CommentRepository's save method:
        commentRepository.save(commentDB);
        return commentDB;
    }

    // DeleteComment method
    // This method will delete a record from the database by the specified id:
    public void deleteComment(Long commentId) {
        commentRepository.deleteById(commentId);
    }
}
