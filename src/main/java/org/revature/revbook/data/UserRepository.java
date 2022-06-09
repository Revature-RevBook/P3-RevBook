package org.revature.revbook.data;

import org.revature.revbook.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    @Query(value = "select * from users where user_name = ?1 and user_email = ?2", nativeQuery = true)
    List<User> findByUserNameEmail(String user_name, String user_email);
}
