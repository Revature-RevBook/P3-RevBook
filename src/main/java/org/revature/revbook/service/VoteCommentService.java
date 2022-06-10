package org.revature.revbook.service;

import org.revature.revbook.data.VoteCommentRepository;
import org.revature.revbook.entity.Comment;
import org.revature.revbook.entity.VoteComment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

@Service
public class VoteCommentService {

    @Autowired
    VoteCommentRepository voteCommentRepository;

    public VoteComment postCommentVote(VoteComment comment){
        voteCommentRepository.save(comment);
        return comment;
    }

    public List<VoteComment> getCommentVotes(long commentId){
        List<VoteComment> votes = voteCommentRepository.findAll();
        List<VoteComment> res = new LinkedList<VoteComment>();
        Iterator< VoteComment > iterator = votes.iterator();

        while(iterator.hasNext()) {
            VoteComment c = iterator.next();
            if(c.getComment_id() == commentId)
                res.add(c);
        }
        return res;
    }

    public VoteComment addVote(VoteComment vote) {
        voteCommentRepository.save(vote);
//        System.out.println(postService.getAllVotes(vote.getPost_id()));
        return vote;
    }

    public VoteComment editVote(VoteComment vote) {
        List<VoteComment> votes = voteCommentRepository.findAll();
        for(VoteComment v : votes){
            if(v.getComment_id() == vote.getComment_id() && v.getVoter_id() == vote.getVoter_id()) {
                System.out.println("Found to update");
                vote.setVote_id(v.getVote_id());
                voteCommentRepository.save(vote);
            }
        }

        return vote;
    }

    public void deleteVotePost(long id){
        voteCommentRepository.deleteById(id);
    }
}
