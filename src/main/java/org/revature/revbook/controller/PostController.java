package org.revature.revbook.controller;

import org.revature.revbook.entity.Post;
import org.revature.revbook.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// PostController Class
// This class will handle the HTTP Requests for the API/resource paths associated with the Post objects.
@CrossOrigin(origins = "*")
@RestController
@RequestMapping(path = "/posts")
public class PostController {

    @Autowired
    PostService postService;

    // PostMapping to add a Post to the database:
    @PostMapping("")
    public Post addPost(@RequestBody Post post) {
        return postService.addPost(post);
    }

    // GetMapping to retrieve a specific Post object from the database:
    @GetMapping("/{postId}")
    public Post getPostById(@PathVariable("postId") Long postId) {
        return postService.getPostById(postId);
    }

    // GetMapping to retrieve Post objects for a specified User from the database:
    @GetMapping("/user/{userId}")
    public List<Post> getAllPostsByUserId(@PathVariable("userId") Long userId) {
        return postService.getAllPostsByUserId(userId);
    }

    // GetMapping to retrieve Post objects from the database:
    @GetMapping("")
    public List<Post> getAllPosts() {
        return postService.getAllPosts();
    }

    // PutMapping to update a specified Post record with the supplied JSON Post object in the database:
    @PutMapping("/{postId}")
    public void updatePost(@PathVariable("postId") Long postId, @RequestBody Post post) {
        postService.updatePost(post, postId);
    }

    // DeleteMapping to delete a specified Post record from the database:
    @DeleteMapping("/{postId}")
    public void deletePost(@PathVariable("postId") Long postId) {
        postService.deletePost(postId);
    }
}
