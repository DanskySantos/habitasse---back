package com.project.habitasse.security.confirmationCode.entities;

import com.project.habitasse.domain.common.SuperclassEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tb_confirmation_code")
public class ConfirmationCode extends SuperclassEntity implements Serializable {

    @Column(name = "code", nullable = false)
    private Integer code;

    @Column(name = "user_id")
    private Integer userId;

    private static Integer generateRandomCode() {
        return (int) (Math.random() * 900000) + 100000;
    }

    public static ConfirmationCode createConfirmationCode(Integer userId) {
        return ConfirmationCode.builder()
                .code(generateRandomCode())
                .userId(userId)
                .build();
    }

    public static ConfirmationCode updateConfirmationCode(ConfirmationCode confirmationCode) {
        confirmationCode.setCode(generateRandomCode());
        return confirmationCode;
    }
}
