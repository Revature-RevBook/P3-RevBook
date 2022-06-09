package org.revature.revbook.controller;

import org.revature.revbook.entity.User;
import org.revature.revbook.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;


    @GetMapping("")
    public List<User> getAll() {
        return userService.get_all_accounts();
    }

    @PutMapping("/update/{user_id}")
    public User updateUser(@RequestBody User user, @PathVariable("user_id") Long user_id) {
        System.out.println("Updated username: " + user_id);
        return userService.updateUser(user, user_id);
    }

    @DeleteMapping("/delete/{user_id}")
    public void deleteUser(@PathVariable("user_id")Long user_id) {userService.delete_user(user_id);}

}
