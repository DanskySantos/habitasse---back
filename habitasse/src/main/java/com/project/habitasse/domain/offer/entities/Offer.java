package com.project.habitasse.domain.offer.entities;

import com.project.habitasse.domain.common.SuperclassEntity;
import com.project.habitasse.domain.demand.entities.Demand;
import com.project.habitasse.security.user.entities.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tb_offer")
@SequenceGenerator(name = "default_gen", sequenceName = "role_seq", allocationSize = 1)
public class Offer extends SuperclassEntity implements Serializable {

    @ManyToOne
    @JoinColumn(name="demand_id", nullable=false)
    private Demand demand;

    @Column(name = "text", nullable=false)
    private String text;

    @ManyToOne
    @JoinColumn(name="user_id", nullable=false)
    private User user;
}
