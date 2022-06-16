package org.revature.revbook.controller;

import org.revature.revbook.entity.PostImage;
import org.revature.revbook.service.PostImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(path = "/post-images")
public class PostImageController {

    @Autowired
    PostImageService postImageService;

    @PostMapping(
            path = "/{postId}",
            consumes = MediaType.MULTIPART_FORM_DATA_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public PostImage addPostImage(@PathVariable("postId") Long postId,
                         @RequestParam("file") MultipartFile file) {
        return postImageService.addPostImage(postId, file);
    }


//    @GetMapping("/{imageId}")
//    public PostImage getPostImageById(@PathVariable("imageId") Long imageId) {
//        return postImageService.getPostImageById(imageId);
//    }

    @RequestMapping(value = "post/{postId}/image/download", method = RequestMethod.GET)
    public byte[] downloadImage(@PathVariable("postId") Long postId) {
        return postImageService.downloadImage(postId);
    }


//    @GetMapping("/post/{postId}")
//    public PostImage getImageByPostId(@PathVariable("postId") Long postId) {
//        return postImageService.getPostImagesByPostId(postId);
//    }
//
//    @GetMapping("")
//    public List<PostImage> getAllPostImages() {
//        return postImageService.getAllPostImages();
//    }
//
//    @PutMapping("/{imageId}")
//    public void updatePostImage(@PathVariable("imageId") Long imageId, @RequestBody PostImage postImage) {
//        postImageService.updatePostImage(imageId, postImage);
//    }
//
//    @DeleteMapping("/{imageId}")
//    public void deletePostImage(@PathVariable("imageId") Long imageId) {
//        postImageService.deletePostImage(imageId);
//    }
}
