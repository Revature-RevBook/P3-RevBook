package org.revature.revbook.service;

import org.revature.revbook.data.PostRepository;
import org.revature.revbook.data.PostImageRepository;
import org.revature.revbook.entity.Post;
import org.revature.revbook.entity.PostImages;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;

@Service
public class PostService {
    @Autowired
    PostRepository postRepository;

    @Autowired
    PostImageRepository post_imageRepository;

    public Post createPost(Post post){return postRepository.save(post);}

    public Post addImageToPost(Long post_id, Long image_id){
        Post post = postRepository.findById(post_id).get();
        PostImages PostImages = post_imageRepository.findById(image_id).get();
        post.addImage(PostImages);
        postRepository.save(post);
        return post;
    }

    public Post removeImageFromPost(Long post_id, Long image_id){
        Post post = postRepository.findById(post_id).get();
        PostImages PostImages = post_imageRepository.findById(image_id).get();
        post.removeImages(PostImages);
        postRepository.save(post);
        return post;
    }

    public Post readPostByPostId(long id) {return postRepository.findById(id).get();}

    public List<Post> readAllPost(){return postRepository.findAll();}

    public Post updatePost(Post post){
        Post postDB = postRepository.findById(post.getPostId()).get();
        postDB.setPostTitle(post.getPostTitle());
        postDB.setUpdatedAt(new Timestamp(System.currentTimeMillis()));
        postDB.setPostContent(post.getPostContent());
        //post.setPost_img(post.getPost_img());
        postRepository.save(postDB);
        return postDB;
    }

    public void deletePost(Long id){postRepository.deleteById(id);}
}
