package org.revature.revbook.controller;

import org.revature.revbook.entity.User;
import org.revature.revbook.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// UserController Class
// This class will handle the HTTP Requests for the API/resource paths associated with the User objects.
@CrossOrigin(origins = "*")
@RestController
@RequestMapping(path = "/users")
public class UserController {

    // PostMapping to add a User to the database:
    @PostMapping("")
    public Boolean addUser(@RequestBody User user) {
        return true;
    }

    // GetMapping to retrieve User objects from the database:
    @GetMapping("")
    public String getAllUsers() {
        return "Get All Users";
    }
}
