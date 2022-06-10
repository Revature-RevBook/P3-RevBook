package org.revature.revbook.service;

import org.revature.revbook.data.UserRepository;
import org.revature.revbook.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
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

    // AddUser method
    // User that is passed from the request will have their password encoded into BCrypt before being
    //  sent to the UserRepository object to save the User to the database:
    public User addUser(User user) {

        userRepository.save(user);
        return user;
    }

    public User authenticate(String username, String password){
        User user = userRepository.getByUserNameAndPassword(username, password).orElse(null);
        return user;
    }

    // GetById method
    // Given the provided userId, this is passed into the UserRepository to query to find that user and
    // return that user:
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

    //ensures no two users share both username and email combo
    public Boolean isUnique(User user) {
        List<User> returnedUsers = userRepository.getByUserNameAndUserEmail(user.getUserName(), user.getUserEmail());
        return returnedUsers.size() < 1;
    }
}
