package org.revature.revbook.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;


import javax.persistence.*;
import java.util.Collection;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@ToString
@Table(name = "users")
public class User {

    // Data members for the User object:
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;
    @Column(unique = true)
    private String username;
    @Column(unique = true)
    private String eMail;
    private String password;

    //Constructor without ID:
    public User(String username, String eMail, String password  ) {
        this.username = username;
        this.eMail = eMail;
        this.password = password;

    }

//    @Override
//    public Collection<? extends GrantedAuthority> getAuthorities() {
//        return null;
//    }
//
//    // IsAccountNonExpired method
//    // This method will return if the user account is expired:
//    @Override
//    public boolean isAccountNonExpired() {
//        return true;
//    }
//
//    // IsAccountNonLocked method
//    // This method will return if the user account is locked:
//    @Override
//    public boolean isAccountNonLocked() {
//        return true;
//    }
//
//    // IsCredentialsNonExpired method
//    // This method will return if the user account's credentials are expired:
//    @Override
//    public boolean isCredentialsNonExpired() {
//        return true;
//    }
//
//    // IsEnabled method
//    // This method will return if the user account is enabled or not:
//    @Override
//    public boolean isEnabled() {
//        return true;
//    }
}