package org.revature.revbook.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.*;
import javax.persistence.Id;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;


@AllArgsConstructor
@Data
@Entity
@ToString
public class Post {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private long postId;
    private String postTitle;
    private Timestamp createdAt;
    private Timestamp updatedAt;
    @Column(columnDefinition = "TEXT")
    private String postContent;
    //Todo ask about storage of an image
    //@JsonManagedReference(value = "post_image")
    @OneToMany(targetEntity = PostImages.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "postFk", referencedColumnName = "postId")
    private List<PostImages> postImages;
//    @ManyToMany(targetEntity = User.class, cascade = CascadeType.ALL)
//    @JoinColumn()
//    private List<User> likes;

    public Post(String post_title, String postContent) {
        this.postTitle = post_title;
        this.createdAt = new Timestamp(System.currentTimeMillis());
        this.updatedAt = new Timestamp(System.currentTimeMillis());
        this.postContent = postContent;
        this.postImages = new ArrayList<>();
    }

    public Post() {
        this.createdAt = new Timestamp(System.currentTimeMillis());
        this.updatedAt = new Timestamp(System.currentTimeMillis());
        this.postImages = new ArrayList<>();
    }

//    public Post(String post_title, String post_content, List<String> post_img) {
//        this.post_title = post_title;
//        this.created_at = new Timestamp(System.currentTimeMillis());
//        this.updated_at = new Timestamp(System.currentTimeMillis());
//        this.post_content = post_content;
//        this.post_img = post_img;
//    }

    public void addImage(PostImages PostImages) {this.postImages.add(PostImages);}
    public void removeImages(PostImages PostImages) {this.postImages.remove(PostImages);}
}
