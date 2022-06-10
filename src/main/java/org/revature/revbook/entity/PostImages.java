package org.revature.revbook.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.*;
import javax.persistence.Id;


@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@ToString

public class PostImages {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private long imageId;
    private String imageUrl;
}
