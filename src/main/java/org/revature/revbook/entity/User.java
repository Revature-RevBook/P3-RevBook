package org.revature.revbook.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Collection;

// Lombok annotations
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@ToString
@Table(name = "users")
public class User implements UserDetails {

    // Data members for the User object:
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;
    @Column(nullable = false, unique = true)
    private String username;
    private String password;
    private Timestamp createdAt;
    private Timestamp updatedAt;
    @Column(unique = true, nullable = false)
    private String email;
    private String profileImgLink;

    // Constructor for checking unique username/email:
    public User(String username, String email) {
        this.username = username;
        this.email = email;
    }

    // Constructor without ID:
    public User(String username, String password, Timestamp createdAt, Timestamp updatedAt, String email, String profileImgLink) {
        this.username = username;
        this.password = password;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.email = email;
        this.profileImgLink = profileImgLink;
    }

    // UserDetails methods
    //=====================

    // GetAuthorities method
    // This is an overridden method from UserDetails Interface that will return a list of SimpleGrantedAuthories.
    // SimpleGrantedAuthority is a String representation of the authority given to the object that is used in
    //  authenticating the User for specified actions involving security (login and HTTP requests).
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
//        return List.of(new SimpleGrantedAuthority("ROLE_" + this.role.getRole_name()));
    }

    // IsAccountNonExpired method
    // This method will return if the user account is expired:
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    // IsAccountNonLocked method
    // This method will return if the user account is locked:
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    // IsCredentialsNonExpired method
    // This method will return if the user account's credentials are expired:
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    // IsEnabled method
    // This method will return if the user account is enabled or not:
    @Override
    public boolean isEnabled() {
        return true;
    }
}