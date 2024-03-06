package com.project.habitasse.domain.demand.entities;

import com.project.habitasse.domain.common.SuperclassEntity;
import com.project.habitasse.domain.enums.*;
import com.project.habitasse.domain.offer.entities.Offer;
import com.project.habitasse.domain.propertyDemand.entities.PropertyDemand;
import com.project.habitasse.domain.propertyDemand.entities.request.PropertyDemandRequest;
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
@Table(name = "tb_demand")
@SequenceGenerator(name = "default_gen", sequenceName = "role_seq", allocationSize = 1)
public class Demand extends SuperclassEntity implements Serializable {

    @OneToOne
    @JoinColumn(name = "property_demand_id", referencedColumnName = "id")
    private PropertyDemand propertyDemand;

    @Column(name = "annotation")
    private String annotation;

    @Column(name = "contact")
    private String contact;

    @OneToMany(mappedBy = "demand", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Offer> offers;

    public static Demand createDemand(PropertyDemandRequest propertyDemandRequest) {
        return Demand.builder()
                .propertyDemand(propertyDemandRequest.getPropertyDemand())
                .annotation(propertyDemandRequest.getAnnotation() != null ? propertyDemandRequest.getAnnotation() : "")
                .contact(propertyDemandRequest.getContact() != null ? propertyDemandRequest.getContact() : "")
                .build();
    }
}
