package org.revature.revbook.controller;

import org.revature.revbook.entity.VotePost;
import org.revature.revbook.service.VotePostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// VotePostController Class
// This class will handle the HTTP Requests for the API/resource paths associated with the VotePost objects.
@CrossOrigin(origins = "*")
@RestController
@RequestMapping(path = "/vote-posts")
public class VotePostController {

    @Autowired
    VotePostService votePostService;

    // PostMapping to add a VotePost to the database:
    @PostMapping("")
    public VotePost addVotePost(@RequestBody VotePost votePost) {
        return votePostService.addVotePost(votePost);
    }

    // GetMapping to retrieve a specific VotePost object from the database:
    @GetMapping("/{voteId}")
    public VotePost getVotePostById(@PathVariable("voteId") Long voteId) {
        return votePostService.getVotePostById(voteId);
    }

    // GetMapping to retrieve VotePost objects for a specified PostId from the database:
    @GetMapping("/post/{postId}")
    public List<VotePost> getAllVotePostsByPostId(@PathVariable("postId") Long postId) {
        return votePostService.getAllVotePostByPostId(postId);
    }

    // GetMapping to retrieve VotePost objects from the database:
    @GetMapping("")
    public List<VotePost> getAllVotePosts() {
        return votePostService.getAllVotePosts();
    }

    // PutMapping to update a specified VotePost record with the supplied JSON VotePost object in the database:
    @PutMapping("/{voteId}")
    public VotePost updateVotePost(@PathVariable("voteId") Long voteId, @RequestBody VotePost votePost) {
        return votePostService.updateVotePost(votePost, voteId);
    }

    // DeleteMapping to delete a specified VotePost record from the database:
    @DeleteMapping("/{voteId}")
    public void deleteVotePost(@PathVariable("voteId") Long voteId) {
        votePostService.deleteVotePost(voteId);
    }
}
