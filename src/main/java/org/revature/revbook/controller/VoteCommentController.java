package org.revature.revbook.controller;

import org.revature.revbook.entity.Comment;
import org.revature.revbook.entity.VoteComment;
import org.revature.revbook.service.CommentService;
import org.revature.revbook.service.VoteCommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins="*")
@RequestMapping("/comment/vote")
public class VoteCommentController {

    @Autowired
    VoteCommentService voteCommentService;

    @PostMapping
    public VoteComment post(@RequestBody VoteComment vote){
        return voteCommentService.postCommentVote(vote);
    }
    @PutMapping
    public VoteComment editVote(@RequestBody VoteComment vote) {return voteCommentService.editVote(vote);}

    @DeleteMapping("/{id}")
    public void deleteVotePost(@PathVariable long id) {voteCommentService.deleteVotePost(id);}

}
