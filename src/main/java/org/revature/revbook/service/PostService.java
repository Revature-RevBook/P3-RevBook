package org.revature.revbook.service;

import org.revature.revbook.data.PostRepository;
import org.revature.revbook.data.VotePostRepository;
import org.revature.revbook.entity.Post;
import org.revature.revbook.entity.VotePost;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;

@Service
public class PostService {
    @Autowired
    PostRepository postRepository;
    @Autowired
    VotePostRepository votePostRepository;

    public Post create_post(Post post){return postRepository.save(post);}

    public Post read_post_by_post_id(long id) {return postRepository.findById(id).get();}

    public List<Post> read_all_post(){return postRepository.findAll();}

    public Post update_post(Post post){
        Post postDB = postRepository.findById(post.getPost_id()).get();
        post.setPost_title(post.getPost_title());
        post.setUpdated_at(new Timestamp(System.currentTimeMillis()));
        post.setPost_content(post.getPost_content());
        //post.setPost_img(post.getPost_img());
        postRepository.save(postDB);
        return postDB;
    }

    public void delete_post(Long id){postRepository.deleteById(id);}

    public void voted(VotePost vote){
        Post postDB = postRepository.findById(vote.getPost_id()).get();
        postDB.getVotes().add(vote);
        postRepository.save(postDB);
    }

    public List<VotePost> getAllVotes(Long post_id) {
        return votePostRepository.findByPostIdIs(post_id);
    }
}