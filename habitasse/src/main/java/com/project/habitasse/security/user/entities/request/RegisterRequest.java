package com.project.habitasse.security.user.entities.request;

import com.project.habitasse.security.roles.entity.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RegisterRequest {

    private Integer id;
    private Integer propertyDemandId;
    private String name;
    private String birthday;
    private String username;
    private String password;
    private String email;
    private String phone;
    private String userRoles;
}
