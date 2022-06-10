package org.revature.revbook.service;

import net.bytebuddy.implementation.bytecode.Throw;
import org.revature.revbook.data.UserRepository;
import org.revature.revbook.entity.User;
import org.revature.revbook.exception.InputException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    final
    UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User getUser(Long user_id) throws Exception {
        Optional<User> userOrNull  = userRepository.findById(user_id);
        if (userOrNull.isPresent()) {
            return userOrNull.get();
        } else {
            throw new Exception("Cannot find the user with id: " + user_id);
        }
    }

    public User register(User user) {
        return userRepository.save(user);
    }

    public Boolean isUnique(User user) {
        List<User> returnedUsers = userRepository.findByUserNameEmail(user.getUser_name(), user.getUser_email());
        return returnedUsers.size() < 1;
    }
}
