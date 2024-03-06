package com.project.habitasse.security.user.resource;


import com.project.habitasse.domain.propertyDemand.entities.request.PropertyDemandRequest;
import com.project.habitasse.security.user.entities.User;
import com.project.habitasse.security.user.service.UserService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin
@RestController
@RequestMapping("/api/v1/user")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/all")
    public List<User> getAll(){
        return userService.findAllUser();
    }

    @GetMapping("/profile")
    public ResponseEntity<?> getByEmail(HttpServletRequest request) {
        return ResponseEntity.ok(userService.findByTokenEmail(request.getHeader("Authorization")));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateUser(@PathVariable Long userId, @RequestBody User updatedUser) {
        User user = userService.updateUser(userId, updatedUser);

        return ResponseEntity.ok(user);
    }
}
