package org.revature.revbook.service;

import org.revature.revbook.data.VotePostRepository;
import org.revature.revbook.entity.VotePost;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VotePostService {
    @Autowired
    VotePostRepository votePostRepository;
    @Autowired
    PostService postService;

    public VotePost addVote(VotePost vote) {
        votePostRepository.save(vote);
        postService.voted(vote);
//        System.out.println(postService.getAllVotes(vote.getPost_id()));
        return vote;
    }

    public VotePost editVote(VotePost vote) {
        votePostRepository.save(vote);
//        System.out.println(postService.getAllVotes(vote.getPost_id()));
        return vote;
    }

    public VotePost getVote(Long post_id, Long user_id) {
        return votePostRepository.findByPostAndUser(post_id, user_id);
    }

    public void deleteVotePost(long id){
        votePostRepository.deleteById(id);
    }
}
