package org.revature.revbook.service;

import org.revature.revbook.data.SubCommentRepository;
import org.revature.revbook.entity.SubComment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

// SubCommentService Class
// This class will handle the business logic for the SubComment objects in the application.
@Service
public class SubCommentService {
    @Autowired
    SubCommentRepository subCommentRepository;

    // AddSubComment method
    // This method will insert a new SubComment object into the database as a record:
    public SubComment addSubComment(SubComment subComment){
        // Add the current time to the createdAt for subComment:
        subComment.setCreatedAt(Timestamp.valueOf(LocalDateTime.now()));

        // Call SubCommentRepository to save the modified comment:
        subCommentRepository.save(subComment);
        return subComment;
    }

    // GetAllSubComments method
    // This method will retrieve the List of SubComment objects from the database:
    public List<SubComment> getAllSubComments(){
        return subCommentRepository.findAll();
    }

    // GetSubCommentById method
    // This method will get a specific SubComment object from the database with the supplied id:
    public SubComment getSubCommentById(Long subCommentId) {
        return subCommentRepository.findById(subCommentId).get();
    }

    // GetAllSubCommentsByComment method
    // This method will retrieve List of SubComments from the database by calling the SubCommentRepository and using the
    //  findByCommentId method which will supply the commentId to the method:
    public List<SubComment> getAllSubCommentsByCommentId(Long commentId) {
        return subCommentRepository.findByCommentId(commentId);
    }

    // UpdateSubComment method
    // This method will update a record in the database by the specified id:
    public SubComment updateSubComment(SubComment subComment, Long subCommentId) {
        // Retrieve the database SubComment object from the database that matches the id:
        SubComment subCommentDB = subCommentRepository.findById(subCommentId).get();

        // Set the database SubComment's attributes to the supplied SubComment object's attributes:
        subCommentDB.setUpdatedAt(Timestamp.valueOf(LocalDateTime.now()));
        subCommentDB.setSubCommentContent(subComment.getSubCommentContent());

        // Update the record in the database through the SubCommentRepository's save method:
        subCommentRepository.save(subCommentDB);
        return subCommentDB;
    }

    // DeleteSubComment method
    // This method will delete a record from the database by the specified id:
    public void deleteSubComment(Long subCommentId) {
        subCommentRepository.deleteById(subCommentId);
    }
}
