package org.revature.revbook.service;

import org.revature.revbook.data.UserRepository;
import org.revature.revbook.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    // AddUser method
    // User that is passed from the request will have their password encoded into BCrypt before being
    //  sent to the UserRepository object to save the User to the database:
    public User addUser(User user) {

        userRepository.save(user);
        return user;
    }

    public User authenticate(String username, String password){
        User user = userRepository.getByUsernameAndPassword(username, password).orElse(null);

//        if(user == null || user.isBanned()){
//            user = null;
//        }
        return user;
    }

    // GetById method
    // Given the provided userId, this is passed into the UserRepository to query to find that user and
    //  return that user:
    public User getById(Long userId) {
        return userRepository.findById(userId).get();
    }

    // GetAllUsers method
    // Calls the UserRepository to query for all Users in the database and return that List object:
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    // UpdateUser method
    // This method will update the user in the database with the provided information:
    public void updateUser(Long userId, User user) {
        // Get User from the database:
        User userDB = userRepository.findById(userId).get();

        // Save the newly updated database User object:
        userRepository.save(userDB);
    }

    // DeleteUser method
    // This will pass the provided userId into the UserRepository to delete the specified user:
    public void deleteUser(Long userId) {
        userRepository.deleteById(userId);
    }

    // LoadUserByUserName method
    // This is the overridden method from the UserDetailsService that is used to retrieve the
    //  User object from the database by querying with the supplied username:

    public User loadUserByUsername(String username) {
        return userRepository.findByUsername(username);
    }

}
