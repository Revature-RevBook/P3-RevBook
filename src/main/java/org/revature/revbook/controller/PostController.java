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
    public Post create_post(@RequestBody Post post) {return postService.create_post(post);}

    @PutMapping("/add")
    public Post add_image_to_post(@RequestBody PostImageDTO postImageDTO) {
        Long post_id = postImageDTO.getPost_id();
        Long image_id = postImageDTO.getImage_id();
        return postService.add_image_to_post(post_id,image_id);
    }

    @GetMapping("/{id}")
    public Post read_post_by_post_id(@PathVariable long id){return postService.read_post_by_post_id(id);}

    @GetMapping
    public List<Post> read_all_post() {return postService.read_all_post();}

    @PutMapping
    public Post update_post(@RequestBody Post post) {return postService.update_post(post);}

    @DeleteMapping("/{id}")
    public void delete_post(@PathVariable long id) {postService.delete_post(id);}


}
