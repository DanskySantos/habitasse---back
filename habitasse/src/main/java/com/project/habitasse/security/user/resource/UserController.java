package com.project.habitasse.security.user.resource;


import com.project.habitasse.domain.propertyDemand.entities.request.PropertyDemandRequest;
import com.project.habitasse.security.user.entities.User;
import com.project.habitasse.security.user.entities.request.UpdateUserPasswordRequest;
import com.project.habitasse.security.user.service.IncorrectPasswordException;
import com.project.habitasse.security.user.service.UserService;
import jakarta.servlet.http.HttpServletRequest;
import org.apache.coyote.BadRequestException;
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
    public ResponseEntity<?> updateUser(@PathVariable Long id, @RequestBody User updatedUser) {
        User user = userService.updateUser(id, updatedUser);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @PutMapping("/password/{username}")
    public ResponseEntity<?> updateUserPassword(
            @PathVariable String username,
            @RequestBody UpdateUserPasswordRequest updateUserPasswordRequest
    ) {
        String currentPassword = updateUserPasswordRequest.getCurrentPassword();
        String newPassword = updateUserPasswordRequest.getNewPassword();

        try {
            Optional<User> updatedUser = userService.updateUserPassword(username, currentPassword, newPassword);
            return ResponseEntity.ok(updatedUser.get());
        } catch (IncorrectPasswordException e) {
            return ResponseEntity.badRequest().body("A senha atual está incorreta");
        }
    }
}
