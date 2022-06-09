package org.revature.revbook.service;

import org.revature.revbook.data.Post_imageRepository;
import org.revature.revbook.entity.post_images;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Post_imageService {
    @Autowired
    Post_imageRepository post_imageRepository;

    public post_images create_post_image(post_images post_img) {return post_imageRepository.save(post_img);}

    public post_images read_post_image_by_id(long id) {return post_imageRepository.findById(id).get();}

    public List<post_images> read_all_post_images() {return post_imageRepository.findAll();}

    public post_images update_post_image(post_images post_images) {
        post_images post_imagesDB = post_imageRepository.findById(post_images.getPost_id()).get();
        post_imagesDB.setImage_url(post_images.getImage_url());
        post_imageRepository.save(post_imagesDB);
        return post_images;
    }

    public void delete_post_image(long id) {
        post_imageRepository.deleteById(id);}
}
