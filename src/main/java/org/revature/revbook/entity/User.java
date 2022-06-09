package org.revature.revbook.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;

// Lombok annotations
// annotate here...
@NoArgsConstructor
@AllArgsConstructor
@Data // getters, setters, toString, HashCode
@Entity
@Table(name = "users")
public class User {
    // Data members for the User object:
    @Id
    @GeneratedValue
    private Long user_id;
    private String user_name;
    private String user_password;
    private String user_email;
    private String user_profile_img_link;
//    @Column(name = "created_at")
    @CreationTimestamp
    private Timestamp created_at;
    @UpdateTimestamp
    private Timestamp updated_at;

    // Constructor without ID:
    public User(String user_name, String user_password, String user_email, String user_profile_img_link, Timestamp created_at, Timestamp updated_at) {
        this.user_name = user_name;
        this.user_password = user_password;
        this.user_email = user_email;
        this.user_profile_img_link = user_profile_img_link;
        this.created_at = created_at;
        this.updated_at = updated_at;
    }
}



