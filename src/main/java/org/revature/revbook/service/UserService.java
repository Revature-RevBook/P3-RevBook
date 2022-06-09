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

    public List<User> get_all_accounts() {
        return userRepository.findAll();
    }

    public void delete_user(Long id) {
        userRepository.deleteById(id);
    }

    public User updateUser(User user, Long user_id){
        User updatedUser = userRepository.findById(user_id).get();
        if (user.getUser_name() != null) {updatedUser.setUser_name(user.getUser_name());}
        if (user.getUser_password() != null) {updatedUser.setUser_password(user.getUser_password());}
        if (user.getUser_email() != null) {updatedUser.setUser_email(user.getUser_email());}
        if (user.getUser_profile_img_link() != null) {updatedUser.setUser_profile_img_link(user.getUser_profile_img_link());}
        return userRepository.save(updatedUser);
    }

}
