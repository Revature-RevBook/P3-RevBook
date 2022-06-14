package org.revature.revbook.service;

import org.revature.revbook.aws.BucketName;
import org.revature.revbook.aws.FileStore;
import org.revature.revbook.data.PostImageRepository;
import org.revature.revbook.data.PostRepository;
import org.revature.revbook.entity.Post;
import org.revature.revbook.entity.PostImage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.*;

import static org.apache.http.entity.ContentType.*;

@Service
public class PostImageService {

    @Autowired
    PostImageRepository postImageRepository;

    @Autowired
    PostRepository postRepository;

    @Autowired
    PostService postService;

    @Autowired
    FileStore fileStore;

    public PostImage addPostImage(Long postId, MultipartFile file) {

        // Check if file is empty:
        if (file.isEmpty()) {
            throw new IllegalStateException("Cannot upload Empty File" + file.getSize());
        }

        // Check if file is INDEED an Image:
        if (Arrays.asList(IMAGE_JPEG, IMAGE_PNG, IMAGE_GIF).contains(file.getContentType())) {
            throw new IllegalStateException("File Must Be of Type Img");
        }

        // Check if post for image to attach to exists:
        Post post = postRepository.findById(postId).get();
        System.out.println(post.getPostContent());
        if (!post.getPostId().equals(postId)) {
            throw new IllegalStateException("Post does not exist.");
        }

        // Get the MetaData from file:
        Map<String, String> metaData = new HashMap<>();
        metaData.put("Content-type", file.getContentType());
        metaData.put("Content-Length", String.valueOf(file.getSize()));

        // Store the image in s3 and update database with s3 image link:
        String path = String.format("%s/%s", BucketName.SITE_IMAGE.getBucketName(), postId);
        String fileName = String.format("%s", file.getOriginalFilename());

        // Try to call the repository to send save the image to the repository:
        try {
            fileStore.upload(path, fileName, Optional.of(metaData), file.getInputStream());
            PostImage postImage = new PostImage(fileName, postId);
            postImage = postImageRepository.save(postImage);
            System.out.println(postImage);
        } catch (IOException e) {
            throw new IllegalStateException(e);
        }

        // Call PostImageRepository to find the new image to obtain its ID.
        //  Then, update the post with the postImage's imageId and call the service to send it to the database:
        PostImage postImage = postImageRepository.findByPostId(postId);
        System.out.println(postImage.getPostId());
        post.setPostImgId(postImage.getImageId());
        postService.updatePost(post, postId);
        return postImage;
    }

//    public PostImage getPostImageById(Long imageId) {
//        return postImageRepository.findById(imageId).get();
//    }
//
//    public PostImage getPostImagesByPostId(Long postId) {
//        return postImageRepository.findByPostId(postId);
//    }
//
//    public List<PostImage> getAllPostImages() {
//        return postImageRepository.findAll();
//    }
//
//    public void updatePostImage(Long imageId, PostImage postImage) {
//        postImageRepository.save(postImage);
//    }
//
//    public void deletePostImage(Long imageId) {
//        postImageRepository.deleteById(imageId);
//    }

    public byte[] downloadImage(Long postId) {
        PostImage postImage = postImageRepository.findByPostId(postId);
        String path = String.format("%s/%s", BucketName.SITE_IMAGE.getBucketName(), postImage.getPostId());
        return fileStore.download(path, postImage.getPostURL());
    }
}
