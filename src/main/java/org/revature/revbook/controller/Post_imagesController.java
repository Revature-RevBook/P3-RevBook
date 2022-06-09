package org.revature.revbook.controller;

import org.revature.revbook.entity.post_images;
import org.revature.revbook.service.Post_imageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/post_image")
public class Post_imagesController {
    @Autowired
    Post_imageService post_imageService;
    
    @PostMapping
    public post_images create_post_images(@RequestBody post_images post_images) {return post_imageService.create_post_image(post_images);}

    @GetMapping("/{id}")
    public post_images read_post_by_post_id(@PathVariable long id){return post_imageService.read_post_image_by_id(id);}

    @GetMapping
    public List<post_images> read_all_post_images() {return post_imageService.read_all_post_images();}

    @PutMapping
    public post_images update_post_images(@RequestBody post_images post_images) {return post_imageService.update_post_image(post_images);}

    @DeleteMapping("/{id}")
    public void delete_post_images(@PathVariable long id) {post_imageService.delete_post_image(id);}
}
