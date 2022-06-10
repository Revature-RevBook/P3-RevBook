package org.revature.revbook.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.*;
import javax.persistence.Id;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@ToString
public class Post {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private long post_id;
    private String post_title;
    private Timestamp created_at;
    private Timestamp updated_at;
    @Column(columnDefinition = "TEXT")
    private String post_content;
    //Todo ask about storage of an image
    @JsonManagedReference(value = "post_image")
    @OneToMany(targetEntity = post_images.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "post_id", referencedColumnName = "post_id")
    private List<String> post_img;

    @OneToMany(targetEntity = VotePost.class, cascade = CascadeType.ALL)
    @JoinColumn(name="post_id", referencedColumnName = "post_id")
    private List<VotePost> votes;

    public Post(String post_title, String post_content) {
        this.post_title = post_title;
        this.created_at = new Timestamp(System.currentTimeMillis());
        this.updated_at = new Timestamp(System.currentTimeMillis());
        this.post_content = post_content;
        //this.likes = new ArrayList<>();
    }

//    public Post(String post_title, String post_content, List<String> post_img) {
//        this.post_title = post_title;
//        this.created_at = new Timestamp(System.currentTimeMillis());
//        this.updated_at = new Timestamp(System.currentTimeMillis());
//        this.post_content = post_content;
//        this.post_img = post_img;
//    }
}
