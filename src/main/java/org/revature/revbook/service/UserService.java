package org.revature.revbook.service;

import org.revature.revbook.data.UserRepository;
import org.revature.revbook.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

// UserService Class
// This class will handle all the business logic for the User objects in the application.
@Service
public class UserService implements UserDetailsService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    // AddUser method
    // User that is passed from the request will have their password encoded into BCrypt before being
    //  sent to the UserRepository object to save the User to the database:
    public User addUser(User user){
        //Encode the user's password:
        user.setPassword(passwordEncoder.encode(user.getPassword()));

        // Add the current time to the createdAt for user:
        user.setCreatedAt(Timestamp.valueOf(LocalDateTime.now()));

        // Call the UserRepository to save the modified user:
        userRepository.save(user);
        return user;
    }

    // GetById method
    // Given the provided userId, this is passed into the UserRepository to query to find that user and
    //  return that user:
    public User getById(Long userId){
        return userRepository.findById(userId).get();
    }

    // GetAllUsers method
    // Calls the UserRepository to query for all Users in the database and return that List object:
    public List<User> getAllUsers(){
        return userRepository.findAll();
    }

    // UpdateUser method
    // This method will update the user in the database with the provided information:
    public User updateUser(User user, Long userId) {
        // Get User from the database:
        User userDB = userRepository.findById(userId).get();

        // Set the database User's attributes with information provided from the supplied User object:
        userDB.setUsername(user.getUsername());
        userDB.setPassword(passwordEncoder.encode(user.getPassword()));
        userDB.setUpdatedAt(Timestamp.valueOf(LocalDateTime.now()));
        userDB.setEmail(user.getEmail());
        userDB.setProfileImgLink(user.getProfileImgLink());

        // Save the newly updated database User object:
        userRepository.save(userDB);
        return userDB;
    }

    // DeleteUser method
    // This will pass the provided userId into the UserRepository to delete the specified user:
    public void deleteUser(Long userId){
        userRepository.deleteById(userId);
    }

    // LoadUserByUserName method
    // This is the overridden method from the UserDetailsService that is used to retrieve the
    //  User object from the database by querying with the supplied username:
    @Override
    public User loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findByUsername(username);
    }

    // CheckIfUserExists method
    // This will check to see if the user exists in the database:
//    public boolean checkIfUserExists(String username) {
//        User user = userRepository.findByUsername(username);
//
//        if(user != null) {
//            return
//        }
//    }

    //ensures no two users share both username and email combo
    public Boolean isUnique(User user) {
        List<User> returnedUsers = userRepository.findByUserNameEmail(user.getUsername(), user.getEmail());
        return returnedUsers.size() < 1;
    }
}

