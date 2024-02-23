package com.project.habitasse.security.user.entities.response;

import com.project.habitasse.security.roles.entity.Role;
import com.project.habitasse.security.user.entities.User;
import com.project.habitasse.security.user.entities.request.RegisterRequest;
import jdk.jshell.Snippet;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserResponse {

    private Integer id;
    private String username;
    private String password;
    private String email;
    private Role role;

    public static UserResponse mapEntityToResponse(RegisterRequest registerRequest) {

        return UserResponse.builder()
                .username(registerRequest.getUsername())
                .password(registerRequest.getPassword())
                .email(registerRequest.getEmail())
                .role(registerRequest.getUserRoles())
                .build();
    }

}
