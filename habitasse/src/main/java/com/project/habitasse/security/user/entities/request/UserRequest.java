package com.project.habitasse.security.user.entities.request;

import com.project.habitasse.security.user.entities.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserRequest {

    private Long id;
    private String username;
    private String password;
    private String email;

    public static User mapRequestToEntity(UserRequest userRequest) {
        User usuario = new User();

        usuario.setId(userRequest.getId());
        usuario.setUsername(userRequest.getUsername());
        usuario.setPassword(userRequest.getPassword());
        usuario.setEmail(userRequest.getEmail());

        return usuario;
    }


}
