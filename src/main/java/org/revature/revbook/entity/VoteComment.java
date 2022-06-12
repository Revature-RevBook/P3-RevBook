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
public class VoteComment {

    // Data members for the VoteComment object:
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long voteId;
    private Timestamp createdAt;
    private Timestamp updatedAt;
    private int vote;
    @Column(nullable = false)
    private Long commentId;
    @Column(nullable = false)
    private Long voterId;

    // Constructor without ID:
    public VoteComment(Timestamp createdAt, Timestamp updatedAt, int vote, Long commentId, Long voterId) {
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.vote = vote;
        this.commentId = commentId;
        this.voterId = voterId;
    }

}
