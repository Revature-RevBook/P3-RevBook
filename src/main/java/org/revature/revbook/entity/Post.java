package org.revature.revbook.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.sql.Timestamp;

// Lombok annotations
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@ToString
public class Post {

    // Data members for the Post object:
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long postId;
    private String postTitle;
    private Timestamp createdAt;
    private Timestamp updatedAt;
    private String postContent;
    private Long postImgId;
    @ManyToOne
    @JoinColumn(name= "user_id", nullable = false)
    private User user;

    // Constructor without ID:
    public Post(String postTitle, Timestamp createdAt, Timestamp updatedAt, String postContent, User user) {
        this.postTitle = postTitle;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.postContent = postContent;
        this.user = user;

    }
}
