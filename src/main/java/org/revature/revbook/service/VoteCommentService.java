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
}
