package org.revature.revbook.controller;

import org.revature.revbook.entity.User;
import org.revature.revbook.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

// SessionController Class
// This class will handle the HTTP Requests for the API/resource paths associated with the Session and User object.
@RestController
@RequestMapping("/session")
public class SessionController {

    @Autowired
    UserService userService;

    // GetSessionUser method
    // This method will retrieve the current user from the database by the supplied username:
    @GetMapping("/{username}")
    public User getSessionUser(@PathVariable("username") String username) {
        return userService.loadUserByUsername(username);
    }
}
