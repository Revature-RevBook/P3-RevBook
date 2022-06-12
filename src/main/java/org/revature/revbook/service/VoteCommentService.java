package org.revature.revbook.service;

import org.revature.revbook.data.VoteCommentRepository;
import org.revature.revbook.entity.VoteComment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

// VoteCommentService Class
// This class will handle the business logic for the VoteComment objects in the application.
@Service
public class VoteCommentService {
    @Autowired
    VoteCommentRepository voteCommentRepository;

    // AddVoteComment method
    // This method will insert a new VoteComment object into the database as a record:
    public VoteComment addVoteComment(VoteComment voteComment){
        // Add the current time to the createdAt for voteComment:
        voteComment.setCreatedAt(Timestamp.valueOf(LocalDateTime.now()));

        // Call the VoteCommentRepository to save the modified voteComment:
        voteCommentRepository.save(voteComment);
        return voteComment;
    }

    // GetAllVoteComments method
    // This method will retrieve the List of VoteComment objects from the database:
    public List<VoteComment> getAllVoteComments(){
        return voteCommentRepository.findAll();
    }

    // GetVoteCommentById method
    // This method will get a specific VoteComment object from the database with the supplied id:
    public VoteComment getVoteCommentById(Long voteId) {
        return voteCommentRepository.findById(voteId).get();
    }

    // GetAllVoteCommentsByVoterId method
    // This method will retrieve List of VoteComments from the database by calling the VoteCommentRepository and using the
    //  findByVoterId method which will supply the voterId to the method:
    public List<VoteComment> getAllVoteCommentsByVoterId(Long voterId) {
        return voteCommentRepository.findByVoterId(voterId);
    }

    // GetAllVoteCommentsByCommentId method
    // This method will retrieve List of VoteComments from the database by calling the VoteCommentRepository and using the
    //  findByCommentId method which will supply the commentId to the method:
    public List<VoteComment> getAllVoteCommentsByCommentId(Long commentId) {
        return voteCommentRepository.findByCommentId(commentId);
    }

    // UpdateVoteComment method
    // This method will update a record in the database by the specified id:
    public VoteComment updateVoteComment(VoteComment voteComment, Long voteId) {
        // Retrieve the database VoteComment object from the database that matches the id:
        VoteComment voteCommentDB = voteCommentRepository.findById(voteId).get();

        // Set the database VoteComment's attributes to the supplied VoteComment object's attributes:
        voteCommentDB.setUpdatedAt(Timestamp.valueOf(LocalDateTime.now()));
        voteCommentDB.setVote(voteComment.getVote());

        // Update the record in the database through the PostRepository's save method:
        voteCommentRepository.save(voteCommentDB);
        return voteCommentDB;
    }

    // DeleteVoteComment method
    // This method will delete a record from the database by the specified id:
    public void deleteVoteComment(Long voteId) {
        voteCommentRepository.deleteById(voteId);
    }
}
