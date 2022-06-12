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
public class VotePost {

    // Data members for the VotePost object:
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long voteId;
    private Timestamp createdAt;
    private Timestamp updatedAt;
    private int vote;
    @Column(nullable = false)
    private Long postId;
    @Column(nullable = false)
    private Long voterId;

    // Constructor without ID:
    public VotePost(Timestamp createdAt, Timestamp updatedAt, int vote, Long postId, Long voterId) {
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.vote = vote;
        this.postId = postId;
        this.voterId = voterId;
    }

}
