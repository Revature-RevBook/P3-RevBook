package org.revature.revbook.data;

import org.revature.revbook.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.Optional;

@CrossOrigin(origins ="*")
@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    // FindByUsername method
    // This method will return a User object from the database:
    public User findByUsername(String username);

    Optional<User> getByUsernameAndPassword(String username, String password);
}
