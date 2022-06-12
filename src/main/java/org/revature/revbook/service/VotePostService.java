package org.revature.revbook.service;

import org.revature.revbook.data.VotePostRepository;
import org.revature.revbook.entity.VotePost;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

// VotePostService Class
// This class will handle the business logic for the VotePost objects in the application.
@Service
public class VotePostService {
    @Autowired
    VotePostRepository votePostRepository;

    // AddVotePost method
    // This method will insert a new VotePost object into the database as a record:
    public VotePost addVotePost(VotePost votePost){
        // Add the current time to the createdAt for votePost:
        votePost.setCreatedAt(Timestamp.valueOf(LocalDateTime.now()));

        // Call the VotePostRepository to save the modified votePost:
        votePostRepository.save(votePost);
        return votePost;
    }

    // GetAllVotePost method
    // This method will retrieve the List of VotePost objects from the database:
    public List<VotePost> getAllVotePosts(){
        return votePostRepository.findAll();
    }

    // GetVotePostById method
    // This method will get a specific VotePost object from the database with the supplied id:
    public VotePost getVotePostById(Long voteId) {
        return votePostRepository.findById(voteId).get();
    }

    // GetAllVotePostByPostId method
    // This method will retrieve List of VotePost objects from the database by calling the VotePostRepository and using the
    //  findByPostId method which will supply the voteId to the method:
    public List<VotePost> getAllVotePostByPostId(Long voteId) {
        return votePostRepository.findByPostId(voteId);
    }

    // UpdateVotePost method
    // This method will update a record in the database by the specified id:
    public VotePost updateVotePost(VotePost votePost, Long voteId) {
        // Retrieve the database VotePost object from the database that matches the id:
        VotePost votePostDB = votePostRepository.findById(voteId).get();

        // Set the database VotePost's attributes to the supplied VotePost object's attributes:
        votePostDB.setUpdatedAt(Timestamp.valueOf(LocalDateTime.now()));
        votePostDB.setVote(votePost.getVote());

        // Update the record in the database through the PostRepository's save method:
        votePostRepository.save(votePostDB);
        return votePostDB;
    }

    // DeleteVotePost method
    // This method will delete a record from the database by the specified id:
    public void deleteVotePost(Long voteId) {
        votePostRepository.deleteById(voteId);
    }
}
