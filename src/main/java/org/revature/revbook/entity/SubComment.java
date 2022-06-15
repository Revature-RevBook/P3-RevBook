package org.revature.revbook.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.sql.Timestamp;

// Lombok annotations
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@ToString
public class SubComment {

    // Data members for the SubComment object:
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long subCommentId;
    private Timestamp createdAt;
    private Timestamp updatedAt;
    private String subCommentContent;
    @ManyToOne
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name= "user_id", nullable = false)
    private User commenter;
    @Column(nullable = false)
    private Long commentId;

    // Constructor without ID:
    public SubComment(Timestamp createdAt, Timestamp updatedAt, String subCommentContent, User commenter, Long commentId) {
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.subCommentContent = subCommentContent;
        this.commenter = commenter;
        this.commentId = commentId;
    }
}
