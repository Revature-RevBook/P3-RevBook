package org.revature.revbook.entity;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.sql.Timestamp;

// Lombok annotations
// annotate here...
@Table(name = "users")
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class User {

    // From Spring website:
    // https://docs.spring.io/spring-data/jpa/docs/current/reference/html/#repositories.query-methods.query-property-expressions
    // Because we treat the underscore character as a reserved character,
    // we strongly advise following standard Java naming conventions
    // (that is, not using underscores in property names but using camel case instead)
    // Data members for the User object:
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;
    @NotBlank(message = "Name cannot be blank") //https://www.baeldung.com/spring-boot-bean-validation
    @Column(unique = true)
    private String userName;
    @NotBlank(message = "Email cannot be blank")
    @Email(message = "Incorrect format")
    @Column(unique = true)
    private String userEmail;
    @NotBlank(message = "password cannot be blank")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String password;
    @CreationTimestamp // https://stackoverflow.com/questions/49954812/how-can-you-make-a-created-at-column-generate-the-creation-date-time-automatical
    private Timestamp createdAt;
    @UpdateTimestamp
    private Timestamp updatedAt;
    private String userProfileImageURL;

    public User(String userName, String userEmail) {
        this.userName = userName;
        this.userEmail = userEmail;
    }

    public User(String userName, String userEmail, String password) {
        this.userName = userName;
        this.userEmail = userEmail;
        this.password = password;
    }
}