package com.project.habitasse.security.user.resource;


import com.project.habitasse.security.user.entities.User;
import com.project.habitasse.security.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("user")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/all")
    public List<User> getAll(){
        return userService.findAllUser();
    }

}
