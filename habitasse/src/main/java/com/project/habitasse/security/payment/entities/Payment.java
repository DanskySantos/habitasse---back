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

    @Column(name = "event_id")
    private String eventId;

    @Column(name = "object_id")
    private String objectId;

    @Column(name = "invoice_id")
    private String invoiceId;

    @Column(name = "balance_transaction_id")
    private String balanceTransactionId;

    @Column(name = "user_name")
    private String userName;

    @Column(name = "created")
    private LocalDateTime created;

    @Column(name = "authorization_date", nullable = false)
    private LocalDateTime authorizationDate;

    @Column(name = "expiration_date", nullable = false)
    private LocalDateTime expirationDate;

    @Column(name = "plan", nullable = false)
    @Enumerated(EnumType.STRING)
    private PlansEnum plan;

    @Column(name = "receipt_url", nullable = false)
    private String receipt_url;

    public static Payment createPayment(Integer userId,
                                        String eventId,
                                        String objectId,
                                        String invoiceId,
                                        String balanceTransactionId,
                                        String userName,
                                        LocalDateTime created,
                                        PlansEnum plan,
                                        String receipt_url) {
        return Payment.builder()
                .userId(userId)
                .eventId(eventId)
                .objectId(objectId)
                .invoiceId(invoiceId)
                .balanceTransactionId(balanceTransactionId)
                .userName(userName)
                .created(created)
                .plan(plan)
                .receipt_url(receipt_url)
                .authorizationDate(created)
                .expirationDate(getExpirationDate(plan, created))
                .build();
    }

    public static LocalDateTime getExpirationDate(PlansEnum plansEnum, LocalDateTime created) {
        return switch (plansEnum) {
            case PLANO_SEMANAL -> created.plusDays(7);
            case PLANO_QUINZENAL -> created.plusDays(15);
            case PLANO_MENSAL -> created.plusDays(30);
            case PLANO_PREMIUM -> created.plusDays(180);
        };
    }
}
