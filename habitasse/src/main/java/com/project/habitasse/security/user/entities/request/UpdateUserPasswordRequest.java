package com.project.habitasse.security.user.entities.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UpdateUserPasswordRequest {
    private String currentPassword;
    private String newPassword;
}
