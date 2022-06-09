package org.revature.revbook.controller;

<<<<<<< HEAD
=======

>>>>>>> e00470297e87e6a9623b08438f6ffb8d923b7c23
import org.revature.revbook.entity.Post;
import org.revature.revbook.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

<<<<<<< HEAD
@CrossOrigin("*")
=======
@CrossOrigin(origins = "*")
>>>>>>> e00470297e87e6a9623b08438f6ffb8d923b7c23
@RestController
@RequestMapping("/posts")
public class PostController {
    @Autowired
    PostService postService;

    @PostMapping
<<<<<<< HEAD
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
=======
    public Post create_post(@RequestBody Post post) {return postService.create_post(post);}

    @GetMapping("/{id}")
    public Post read_post_by_post_id(@PathVariable long id){return postService.read_post_by_post_id(id);}

    @GetMapping
    public List<Post> read_all_post() {return postService.read_all_post();}

    @PutMapping
    public Post update_post(@RequestBody Post post) {return postService.update_post(post);}

    @DeleteMapping("/{id}")
    public void delete_post(@PathVariable long id) {postService.delete_post(id);}
>>>>>>> e00470297e87e6a9623b08438f6ffb8d923b7c23
}
