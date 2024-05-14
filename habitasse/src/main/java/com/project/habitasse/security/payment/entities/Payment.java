package com.project.habitasse.security.payment.entities;

import com.project.habitasse.domain.common.SuperclassEntity;
import com.project.habitasse.outside.enums.PlansEnum;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tb_payment")
public class Payment extends SuperclassEntity implements Serializable {

    @Column(name = "user_id")
    private Integer userId;

    @Column(name = "plan", nullable = false)
    @Enumerated(EnumType.STRING)
    private PlansEnum plan;

    @Column(name = "event_id")
    private String eventId;

    @Column(name = "object_id")
    private String objectId;

    @Column(name = "user_name")
    private String userName;

    @Column(name = "client_reference")
    private Integer clientReference;

    @Column(name = "amount_total")
    private Double amountTotal;

    @Column(name = "authorization_date", nullable = false)
    private LocalDateTime authorizationDate;

    @Column(name = "expiration_date", nullable = false)
    private LocalDateTime expirationDate;

    public static Payment createPayment(Integer userId,
                                        PlansEnum plan,
                                        String eventId,
                                        String objectId,
                                        String userName,
                                        Integer clientReference,
                                        Double amountTotal,
                                        LocalDateTime created) {
        return Payment.builder()
                .userId(userId)
                .plan(plan)
                .eventId(eventId)
                .objectId(objectId)
                .userName(userName)
                .clientReference(clientReference)
                .amountTotal(amountTotal)
                .authorizationDate(created)
                .expirationDate(getExpirationDate(plan, created))
                .build();
    }

    public static LocalDateTime getExpirationDate(PlansEnum plansEnum, LocalDateTime created) {
        return switch (plansEnum) {
            case PLANO_BASICO -> created.plusDays(15);
            case PLANO_ESSENCIAL -> created.plusDays(30);
            case PLANO_PRO -> created.plusDays(180);
            case PLANO_PREMIUM -> created.plusDays(365);
        };
    }
}
