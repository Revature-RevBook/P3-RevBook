package org.revature.revbook.service;

import org.revature.revbook.data.PostRepository;
import org.revature.revbook.entity.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;

@CrossOrigin("*")
@Service
public class PostService {
    @Autowired
    PostRepository postRepository;

    public Post addPost(Post post){
        postRepository.save(post);
        return post;
    }

    public List<Post> getAllPosts(){
        return postRepository.findAll();
    }

    public Post getPostById(long postId){
        return postRepository.getById(postId);
    }

    public long getLikesByPostId(long postId){
        return postRepository.getById(postId).getLikes();
    }

    public Post updatePost(Post post, long id){
        Post postDB = postRepository.getById(id);
        postDB.setUserId(post.getUserId());
        postDB.setPostBody(post.getPostBody());
        postDB.setLikes(post.getLikes());

        postRepository.save(postDB);
        return postDB;
    }

    public Post updateLikesById(long id){
        Post postDB = postRepository.getById(id);
        postDB.setLikes(postDB.getLikes() + 1);

        postRepository.save(postDB);
        return postDB;
    }

    public void deletePostById(long id){
        postRepository.deleteById(id);
    }
}
