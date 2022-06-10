package org.revature.revbook.controller;

import org.revature.revbook.entity.VotePost;
import org.revature.revbook.service.PostService;
import org.revature.revbook.service.VotePostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class VotePostController {
    @Autowired
    VotePostService votePostService;

    @PostMapping("/posts/{id}/vote")
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

}
