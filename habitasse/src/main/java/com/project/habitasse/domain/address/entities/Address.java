package com.project.habitasse.domain.address.entities;

import com.project.habitasse.domain.common.SuperclassEntity;
import com.project.habitasse.domain.propertyDemand.entities.request.PropertyDemandRequest;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.SequenceGenerator;
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
@Table(name = "tb_address")
@SequenceGenerator(name = "default_gen", sequenceName = "role_seq", allocationSize = 1)
public class Address extends SuperclassEntity implements Serializable {

    @Column(name = "country", length = 255)
    private String country;

    @Column(name = "state", length = 255)
    private String state;

    @Column(name = "city", length = 255)
    private String city;

    public static Address createAddress(PropertyDemandRequest propertyDemandRequest) {
        return Address.builder()
                .country("Brasil")
                .state(propertyDemandRequest.getState())
                .city(propertyDemandRequest.getCity())
                .build();
    }
}
