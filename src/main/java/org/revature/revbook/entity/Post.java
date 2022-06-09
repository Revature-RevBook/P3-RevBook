package org.revature.revbook.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.*;
import javax.persistence.Id;
import java.sql.Timestamp;
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
    //private List<String> post_img;

    public Post(String post_title, String post_content) {
        this.post_title = post_title;
        this.created_at = new Timestamp(System.currentTimeMillis());
        this.updated_at = new Timestamp(System.currentTimeMillis());
        this.post_content = post_content;
    }

//    public Post(String post_title, String post_content, List<String> post_img) {
//        this.post_title = post_title;
//        this.created_at = new Timestamp(System.currentTimeMillis());
//        this.updated_at = new Timestamp(System.currentTimeMillis());
//        this.post_content = post_content;
//        this.post_img = post_img;
//    }
}
