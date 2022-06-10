package org.revature.revbook.controller;

import org.revature.revbook.entity.PostImages;
import org.revature.revbook.service.PostImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/post_image")
public class PostImagesController {
    @Autowired
    PostImageService postImageService;
    
    @PostMapping
    public PostImages createPostImages(@RequestBody PostImages PostImages) {return postImageService.createPostImage(PostImages);}

    @GetMapping("/{id}")
    public PostImages readPostByPostId(@PathVariable long id){return postImageService.readPostImageById(id);}

    @GetMapping
    public List<PostImages> readAllPostImages() {return postImageService.readAllPostImages();}

    @PutMapping
    public PostImages updatePostImages(@RequestBody PostImages PostImages) {return postImageService.updatePostImage(PostImages);}

    @DeleteMapping("/{id}")
    public void deletePostImages(@PathVariable long id) {
        postImageService.deletePostImage(id);}
}
