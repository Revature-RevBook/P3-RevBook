package org.revature.revbook.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;

@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "voteComments")
public class VoteComment {
    @Id
    @GeneratedValue
    private int vote_id;
    @Column(name = "created_at")
    @CreationTimestamp
    private Timestamp created_at;
    @Column(name = "updated_at")
    @UpdateTimestamp
    private Timestamp updated_at;
    private int vote;
    private long comment_id;
    private long voter_id;

}
