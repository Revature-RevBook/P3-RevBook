package org.revature.revbook.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@ToString
public class PostImage {

    // Data members for the PostImage object:
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long imageId;
    private String postURL;
    @Column(unique = true)
    private Long postId;

    // Constructor without ID:
    public PostImage(String postURL, Long postId) {
        this.postURL = postURL;
        this.postId = postId;
    }
}
