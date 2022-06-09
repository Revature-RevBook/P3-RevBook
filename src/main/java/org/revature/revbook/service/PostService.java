package org.revature.revbook.service;

import org.revature.revbook.data.PostRepository;
import org.revature.revbook.data.Post_imageRepository;
import org.revature.revbook.entity.Post;
import org.revature.revbook.entity.post_images;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;

@Service
public class PostService {
    @Autowired
    PostRepository postRepository;

    @Autowired
    Post_imageRepository post_imageRepository;

    public Post create_post(Post post){return postRepository.save(post);}

    public Post add_image_to_post(Long post_id, Long image_id){
        Post post = postRepository.findById(post_id).get();
        post_images post_images = post_imageRepository.findById(image_id).get();
        post.addImage(post_images);
        postRepository.save(post);
        return post;
    }

    public Post remove_image_from_post(Long post_id, Long image_id){
        Post post = postRepository.findById(post_id).get();
        post_images post_images = post_imageRepository.findById(image_id).get();
        post.removeImages(post_images);
        postRepository.save(post);
        return post;
    }

    public Post read_post_by_post_id(long id) {return postRepository.findById(id).get();}

    public List<Post> read_all_post(){return postRepository.findAll();}

    public Post update_post(Post post){
        Post postDB = postRepository.findById(post.getPost_id()).get();
        postDB.setPost_title(post.getPost_title());
        postDB.setUpdated_at(new Timestamp(System.currentTimeMillis()));
        postDB.setPost_content(post.getPost_content());
        //post.setPost_img(post.getPost_img());
        postRepository.save(postDB);
        return postDB;
    }

    public void delete_post(Long id){postRepository.deleteById(id);}
}
