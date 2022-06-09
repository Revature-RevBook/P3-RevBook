package org.revature.revbook.entity;

import javax.persistence.Entity;

import java.sql.Timestamp;
import java.util.List;
import java.util.Set;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;

@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "comments")
public class Comment {
    @Id
    @GeneratedValue
    private Long id;
    private String commentTxt;
    @Column(name = "creation_date")
    @CreationTimestamp
    private Timestamp currentDate;
    @Column(name="parent_id")
    private Long parentId;
    @OneToMany(fetch=FetchType.EAGER, cascade=CascadeType.PERSIST)
    @JoinColumn(name="parent_id")
    List<Comment> replyComment;
}
