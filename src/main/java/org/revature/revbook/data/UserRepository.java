package org.revature.revbook.data;

import org.revature.revbook.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    // FindByUsername method
    // This method will return a User object from the database:
    public User findByUserName(String userName);


    Optional<User> getByUserNameAndPassword(String userName, String password);

    List<User> getByUserNameAndUserEmail(String userName, String userEmail);
}
