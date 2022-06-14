package org.revature.revbook.controller;

import org.revature.revbook.entity.User;
import org.revature.revbook.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;
import java.util.Map;

// UserController Class
// This class will handle the HTTP Requests for the API/resource paths associated with the User objects.
@CrossOrigin(origins = "*")
@RestController
@RequestMapping(path = "/users")
public class UserController {

    @Autowired
    UserService userService;

    // PostMapping to add a User to the database:
    @PostMapping("")
    public Boolean addUser(@RequestBody User user) {
        userService.addUser(user);
        return true;
    }

    // GetMapping to retrieve User objects from the database:
    @GetMapping("")
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    // GetMapping to retrieve a specific User object from the database:
    @GetMapping("/{userId}")
    public User getUserById(@PathVariable("userId") Long userId) {
        return userService.getById(userId);
    }

    // PutMapping to update a specified User with the supplied JSON User object in the database:
    @PutMapping("/{userId}")
    public boolean updateUser(@PathVariable("userId") Long userId, @RequestBody User user) {
        userService.updateUser(user, userId);
        return true;
    }

    // DeleteMapping to delete a specified user from the database:
    @DeleteMapping("/{userId}")
    public boolean deleteUser(@PathVariable("userId") Long userId) {
        userService.deleteUser(userId);
        return true;
    }

    @RequestMapping(path = "/unique", method = RequestMethod.GET)
    public Map<String, Boolean> isUnique(@RequestParam(name = "username") String username,
                                         @RequestParam(name = "email") String email) {
        User user = new User(username, email);
        Boolean isUnique = userService.isUnique(user);
        if (isUnique) {
            return Collections.singletonMap("isUnique" , isUnique);
        }
        return Collections.singletonMap("isUnique" , false);
    }
}
