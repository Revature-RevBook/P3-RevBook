package org.revature.revbook.controller;

import org.revature.revbook.entity.VoteComment;
import org.revature.revbook.service.VoteCommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// VoteCommentController Class
// This class will handle the HTTP Requests for the API/resource paths associated with the VoteComment objects.
@CrossOrigin(origins = "*")
@RestController
@RequestMapping(path = "/vote-comments")
public class VoteCommentController {

    @Autowired
    VoteCommentService voteCommentService;

    // PostMapping to add a VoteComment to the database:
    @PostMapping("")
    public VoteComment addVoteComment(@RequestBody VoteComment voteComment) {
        return voteCommentService.addVoteComment(voteComment);
    }

    // GetMapping to retrieve a specific VoteComment object from the database:
    @GetMapping("/{voteId}")
    public VoteComment getVoteCommentById(@PathVariable("voteId") Long voteId) {
        return voteCommentService.getVoteCommentById(voteId);
    }

    // GetMapping to retrieve VoteComment objects for a specified VoterId from the database:
    @GetMapping("/voter/{voterId}")
    public List<VoteComment> getAllVoteCommentsByVoterId(@PathVariable("voterId") Long voterId) {
        return voteCommentService.getAllVoteCommentsByVoterId(voterId);
    }

    // GetMapping to retrieve VoteComment objects for a specified CommentId from the database:
    @GetMapping("/comment/{commentId}")
    public List<VoteComment> getAllVoteCommentsByCommentId(@PathVariable("commentId") Long commentId) {
        return voteCommentService.getAllVoteCommentsByCommentId(commentId);
    }

    // GetMapping to retrieve VoteComment objects from the database:
    @GetMapping("")
    public List<VoteComment> getAllVoteComments() {
        return voteCommentService.getAllVoteComments();
    }

    // PutMapping to update a specified VoteComment record with the supplied JSON VoteComment object in the database:
    @PutMapping("/{voteId}")
    public VoteComment updateVoteComment(@PathVariable("voteId") Long voteId, @RequestBody VoteComment voteComment) {
        return voteCommentService.updateVoteComment(voteComment, voteId);
    }

    // DeleteMapping to delete a specified VoteComment record from the database:
    @DeleteMapping("/{voteId}")
    public void deleteVoteComment(@PathVariable("voteId") Long voteId) {
        voteCommentService.deleteVoteComment(voteId);
    }
}
