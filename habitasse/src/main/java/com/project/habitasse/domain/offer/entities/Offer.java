package com.project.habitasse.domain.offer.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.project.habitasse.domain.common.SuperclassEntity;
import com.project.habitasse.domain.demand.entities.Demand;
import com.project.habitasse.domain.offer.entities.request.OfferRequest;
import jakarta.persistence.*;
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
@Table(name = "tb_offer")
@SequenceGenerator(name = "default_gen", sequenceName = "role_seq", allocationSize = 1)
public class Offer extends SuperclassEntity implements Serializable {

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name="demand_id", nullable=false)
    private Demand demand;

    @Column(name = "text", nullable=false)
    private String text;

    @Column(name = "user_id")
    private Integer userId;

    @Column(name = "user_email")
    private String userEmail;

    @Column(name = "username_user")
    private String username;

    @Column(name = "user_contact")
    private String contact;

    @Column(name = "accepted")
    private boolean accepted = false;

    @Column(name = "deleted")
    private boolean isDeleted = false;

    public static Offer createOffer(OfferRequest offerRequest) {
        return Offer.builder()
                .demand(offerRequest.getDemand())
                .text(offerRequest.getText())
                .userId(offerRequest.getUser().getId())
                .userEmail(offerRequest.getUser().getEmail())
                .username(offerRequest.getUser().getUsernameForDto())
                .contact(offerRequest.getContact())
                .build();
    }

    public static Offer updateOffer(Offer offer, OfferRequest offerRequest) {
        offer.setText(offerRequest.getText());
        return offer;
    }

    public static void acceptedOffer(Offer offer){
     offer.setAccepted(true);
    }

    public static Offer delete(Offer offer){
        offer.setDeleted(true);
        return offer;
    }
}
