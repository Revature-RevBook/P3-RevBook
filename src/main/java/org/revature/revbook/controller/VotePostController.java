package org.revature.revbook.controller;

import org.revature.revbook.entity.Post;
import org.revature.revbook.entity.VotePost;
import org.revature.revbook.service.PostService;
import org.revature.revbook.service.VotePostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/votes")
public class VotePostController {
    @Autowired
    VotePostService votePostService;

    @PostMapping
    public VotePost vote(@RequestBody VotePost vote, @PathVariable("id") Long post_id) {
        vote.setPost_id(post_id);
        //HARDCODED
        vote.setVoter_id(1);//HARDCODED
        //HARDCODED
        //HARDCODED
        //HARDCODED
        if (votePostService.getVote(post_id, Long.valueOf(1)) != null) {
            //HARDCODED
            //HARDCODED
            System.out.println("Not gonna work, it already exists");
            return null;
        } else {
            return votePostService.addVote(vote);
        }
    }

    @GetMapping("/{post_id}/{user_id}")
    public VotePost getVotePostByPostAndUserId(@PathVariable long post_id, @PathVariable long user_id){return votePostService.getVote(post_id, user_id);}

    @PutMapping
    public VotePost update_post(@RequestBody VotePost vote) {return votePostService.editVote(vote);}

    @DeleteMapping("/{id}")
    public void delete_post(@PathVariable long id) {votePostService.deleteVotePost(id);}

}
