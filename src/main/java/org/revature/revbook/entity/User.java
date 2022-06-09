package org.revature.revbook.entity;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.sql.Timestamp;

// Lombok annotations
// annotate here...
@Table(name = "users")
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class User {

    // Data members for the User object:
    @Id
    @GeneratedValue
    private Long user_id;
    @NotBlank(message = "Name cannot be blank") //https://www.baeldung.com/spring-boot-bean-validation
    @Column(unique = true)
    private String user_name;
    @NotBlank(message = "Email cannot be blank")
    @Email(message = "Incorrect format")
    @Column(unique = true)
    private String user_email;
    @NotBlank(message = "password cannot be blank")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String password;
    @CreationTimestamp // https://stackoverflow.com/questions/49954812/how-can-you-make-a-created-at-column-generate-the-creation-date-time-automatical
    private Timestamp created_at;
    @UpdateTimestamp
    private Timestamp updated_at;
    private String user_profile_image_url;

    public User(String user_name, String user_email) {
        this.user_name = user_name;
        this.user_email = user_email;
    }

    // Constructor without ID:

}