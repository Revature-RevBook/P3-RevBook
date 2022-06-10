package org.revature.revbook.service;

import org.revature.revbook.data.PostImageRepository;
import org.revature.revbook.entity.PostImages;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostImageService {
    @Autowired
    PostImageRepository postImageRepository;

    public PostImages createPostImage(PostImages post_img) {return postImageRepository.save(post_img);}

    public PostImages readPostImageById(long id) {return postImageRepository.findById(id).get();}

    public List<PostImages> readAllPostImages() {return postImageRepository.findAll();}

    public PostImages updatePostImage(PostImages PostImages) {
        PostImages postImagesDB = postImageRepository.findById(PostImages.getImageId()).get();
        postImagesDB.setImageUrl(PostImages.getImageUrl());
        postImageRepository.save(postImagesDB);
        return PostImages;
    }

    public void deletePostImage(long id) {
        postImageRepository.deleteById(id);}
}
