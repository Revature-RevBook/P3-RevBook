package org.revature.revbook.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.web.bind.annotation.CrossOrigin;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@CrossOrigin(origins="*")
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
@Entity
public class Post {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private long postId;
    private long userId;
    private String postBody;
    private long likes;

    Post(long userId){
        this.userId = userId;
        this.postBody = "";
        this.likes = 0;
    }
}
