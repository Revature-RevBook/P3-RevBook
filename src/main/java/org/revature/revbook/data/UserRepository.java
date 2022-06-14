package org.revature.revbook.data;


import org.revature.revbook.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

// UserRepository Interface Class
// This interface class will handle the data logic of the User objects in the database for the application.
@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    // FindByUsername method
    // This method will return a User object from the database:
    public User findByUsername(String username);

    @Query(value = "select * from users where username = ?1 or email = ?2", nativeQuery = true)
    List<User> findByUserNameEmail(String user_name, String user_email);

}
