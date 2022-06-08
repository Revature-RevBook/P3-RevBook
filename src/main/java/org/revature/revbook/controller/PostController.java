package org.revature.revbook.controller;

import org.revature.revbook.entity.Post;
import org.revature.revbook.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/posts")
public class PostController {
    @Autowired
    PostService postService;

    @PostMapping
    public Post addPost(@RequestBody Post post){
        System.out.println(post.toString());
        System.out.println("test");
        return postService.addPost(post);
    }

    @GetMapping
    public List<Post> getAllPosts(){
        return postService.getAllPosts();
    }

    @GetMapping("/{id}")
    public Post getPostById(@PathVariable("id") long id){
        return postService.getPostById(id);
    }

    @PutMapping("/{id}")
    public Post updatePost(@RequestBody Post post, @PathVariable("id") long id){
        return postService.updatePost(post, id);
    }

    @PutMapping("/liked/{id}")
    public Post updateLikesById(@PathVariable("id") long id){
        return postService.updateLikesById(id);
    }

    @DeleteMapping("/{id}")
    public void deletePostById(@PathVariable("id") long id){
        postService.deletePostById(id);
    }
}
