package org.revature.revbook.service;

import org.revature.revbook.data.PostRepository;
import org.revature.revbook.entity.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

// PostService Class
// This class will handle the business logic for the Post objects in the application.
@Service
public class PostService {
    @Autowired
    PostRepository postRepository;

    // AddPost method
    // This method will insert a new Post object into the database as a record:
    public Post addPost(Post post){
        // Add the current time to the createdAt for post:
        post.setCreatedAt(Timestamp.valueOf(LocalDateTime.now()));

        // Call the PostRepository to save the modified post:
        postRepository.save(post);
        return post;
    }

    // GetAllPosts method
    // This method will retrieve the List of Post objects from the database:
    public List<Post> getAllPosts(){
        return postRepository.findAll();
    }

    // GetPostById method
    // This method will get a specific Post object from the database with the supplied id:
    public Post getPostById(Long postId) {
        return postRepository.findById(postId).get();
    }

    // GetAllPostsByUserId method
    // This method will retrieve List of Post from the database by calling the PostRepository and using the
    //  findByUserId method which will supply the userId to the method:
    public List<Post> getAllPostsByUserId(Long userId) {
        return postRepository.findByUserUserId(userId);
    }

    // UpdatePost method
    // This method will update a record in the database by the specified id:
    public Post updatePost(Post post, Long postId) {
        // Retrieve the database Post object from the database that matches the id:
        Post postDB = postRepository.findById(postId).get();

        // Set the database Post's attributes to the supplied Post object's attributes:
        postDB.setPostTitle(post.getPostTitle());
        postDB.setUpdatedAt(Timestamp.valueOf(LocalDateTime.now()));
        postDB.setPostContent(post.getPostContent());
        postDB.setPostImgId(post.getPostImgId());

        // Update the record in the database through the PostRepository's save method:
        postRepository.save(postDB);
        return postDB;
    }

    // DeletePost method
    // This method will delete a record from the database by the specified id:
    public void deletePost(Long postId) {
        postRepository.deleteById(postId);
    }
}


