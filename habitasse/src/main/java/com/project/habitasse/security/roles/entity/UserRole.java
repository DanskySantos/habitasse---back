package com.project.habitasse.security.roles.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tb_user_role")
public class UserRole implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String roleName;

//    public static Role createRoleForUser(UserRequest userRequest) {
//        Role role= new Role();
//        role.setRoleName(userRequest.getNomeCompleto());
//        return role;
//    }
}
