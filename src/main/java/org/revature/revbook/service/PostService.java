package org.revature.revbook.service;

import org.revature.revbook.data.PostRepository;
import org.revature.revbook.entity.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
<<<<<<< HEAD
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;

@CrossOrigin("*")
=======

import java.sql.Timestamp;
import java.util.List;

>>>>>>> e00470297e87e6a9623b08438f6ffb8d923b7c23
@Service
public class PostService {
    @Autowired
    PostRepository postRepository;

<<<<<<< HEAD
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

=======
    public Post create_post(Post post){return postRepository.save(post);}

    public Post read_post_by_post_id(long id) {return postRepository.findById(id).get();}

    public List<Post> read_all_post(){return postRepository.findAll();}

    public Post update_post(Post post){
        Post postDB = postRepository.findById(post.getPost_id()).get();
        post.setPost_title(post.getPost_title());
        post.setUpdated_at(new Timestamp(System.currentTimeMillis()));
        post.setPost_content(post.getPost_content());
        //post.setPost_img(post.getPost_img());
>>>>>>> e00470297e87e6a9623b08438f6ffb8d923b7c23
        postRepository.save(postDB);
        return postDB;
    }

<<<<<<< HEAD
    public Post updateLikesById(long id){
        Post postDB = postRepository.getById(id);
        postDB.setLikes(postDB.getLikes() + 1);

        postRepository.save(postDB);
        return postDB;
    }

    public void deletePostById(long id){
        postRepository.deleteById(id);
    }
=======
    public void delete_post(Long id){postRepository.deleteById(id);}
>>>>>>> e00470297e87e6a9623b08438f6ffb8d923b7c23
}
