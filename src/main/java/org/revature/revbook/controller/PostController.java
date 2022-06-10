package org.revature.revbook.controller;


import org.revature.revbook.dto.PostImageDTO;
import org.revature.revbook.entity.Post;
import org.revature.revbook.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/posts")
public class PostController {
    @Autowired
    PostService postService;

    @PostMapping
    public Post createPost(@RequestBody Post post) {return postService.createPost(post);}

    @PutMapping("/add")
    public Post addImageToPost(@RequestBody PostImageDTO postImageDTO) {
        Long post_id = postImageDTO.getPost_id();
        Long image_id = postImageDTO.getImage_id();
        return postService.addImageToPost(post_id,image_id);
    }

    @GetMapping("/{id}")
    public Post readPostByPostId(@PathVariable long id){return postService.readPostByPostId(id);}

    @GetMapping
    public List<Post> readAllPost() {return postService.readAllPost();}

    @PutMapping
    public Post updatePost(@RequestBody Post post) {return postService.updatePost(post);}

    @DeleteMapping("/{id}")
    public void deletePost(@PathVariable long id) {postService.deletePost(id);}


}
