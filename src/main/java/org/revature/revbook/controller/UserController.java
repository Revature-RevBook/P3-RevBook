package org.revature.revbook.controller;

import org.revature.revbook.entity.User;
import org.revature.revbook.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Collections;
import java.util.Map;

@RestController
@RequestMapping ("api/v1/user")
@CrossOrigin(origins = "http://localhost:4200/")
public class UserController {

    @Autowired
    UserService userService;

    @RequestMapping(path = "{userId}", method = RequestMethod.GET)
    public User getUser(@Valid @PathVariable("userId") Long userId) {
        try {
            return userService.getUser(userId);
        } catch (Exception e) {
            ResponseEntity.badRequest();
            throw new RuntimeException(e);
        }
    }

    @GetMapping("/login")
    public User login(@RequestParam String username, @RequestParam String password){
        return userService.authenticate(username, password);
    }


    @RequestMapping(path = "", method = RequestMethod.POST)
    public User register(@Valid @RequestBody User user) {
        return  userService.register(user);
    }

    @RequestMapping(path = "/unique", method = RequestMethod.GET)
    public Map<String, Boolean> isUnique(@RequestParam(name = "userName") String userName,
                                         @RequestParam(name = "userEmail") String userEmail) {
        User user = new User(userName, userEmail);
        Boolean isUnique = userService.isUnique(user);
        if (isUnique) {
            System.out.println("here");
            return Collections.singletonMap("isUnique" , isUnique);
        }
        System.out.println("here");
        return Collections.singletonMap("isUnique" , false);
    }


}