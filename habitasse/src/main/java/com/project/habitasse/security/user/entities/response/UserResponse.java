package com.project.habitasse.security.user.entities.response;

import com.project.habitasse.security.user.entities.User;
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

    private Long id;
    private String username;
    private String password;
    private String email;

    public static UserResponse mapEntityToResponse(User result) {

        return UserResponse.builder()
                .id(result.getId())
                .username(result.getUsername())
                .password(result.getPassword())
                .email(result.getEmail())
                .build();
    }

}
