package org.revature.revbook.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.sql.Timestamp;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class VotePost {
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
    private long post_id;
    private long voter_id;



}