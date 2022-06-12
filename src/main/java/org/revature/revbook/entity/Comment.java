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
public class Comment {

    // Data members for the Comment object:
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long commentId;
    private Timestamp createdAt;
    private Timestamp updatedAt;
    private String commentContent;
    @Column(nullable = false)
    private Long commenterId;
    @Column(nullable = false)
    private Long postId;


    // Constructor without ID:
    public Comment(Timestamp createdAt, Timestamp updatedAt, String commentContent, Long commenterId, Long postId) {
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.commentContent = commentContent;
        this.commenterId = commenterId;
        this.postId = postId;
    }

}
