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

    @RequestMapping(path = "{user_id}", method = RequestMethod.GET)
    public User getUser(@Valid @PathVariable("user_id") Long user_id) {
        try {
            return userService.getUser(user_id);
        } catch (Exception e) {
            ResponseEntity.badRequest();
            throw new RuntimeException(e);
        }
    }

    @RequestMapping(path = "", method = RequestMethod.POST)
    public User register(@Valid @RequestBody User user) {
        return  userService.register(user);
    }

    @RequestMapping(path = "/unique", method = RequestMethod.GET)
    public Map<String, Boolean> isUnique(@RequestParam(name = "user-name") String user_name,
                                         @RequestParam(name = "user-email") String user_email) {
        User user = new User(user_name, user_email);
        Boolean isUnique = userService.isUnique(user);
        if (isUnique) {
            System.out.println("here");
            return Collections.singletonMap("isUnique" , isUnique);
        }
        System.out.println("here");
        return Collections.singletonMap("isUnique" , false);

    }


}
