package com.project.habitasse.domain.propertyDemand.entities;

import com.project.habitasse.domain.address.entities.Address;
import com.project.habitasse.domain.common.SuperclassEntity;
import com.project.habitasse.domain.demand.entities.Demand;
import com.project.habitasse.domain.enums.*;
import com.project.habitasse.domain.propertyDemand.entities.request.PropertyDemandRequest;
import com.project.habitasse.security.user.entities.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.util.StringUtils;

import java.io.Serializable;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tb_property_demand")
@SequenceGenerator(name = "default_gen", sequenceName = "role_seq", allocationSize = 1)
public class PropertyDemand extends SuperclassEntity implements Serializable {

    @Column(name = "contract_type", nullable = false)
    @Enumerated(EnumType.STRING)
    private ContractTypeEnum contractType;

    @Column(name = "property_type", nullable = false)
    @Enumerated(EnumType.STRING)
    private PropertyTypeEnum propertyType;

    @Column(name = "bedrooms_number", nullable = false)
    @Enumerated(EnumType.STRING)
    private BedroomsNumberEnum bedroomsNumber;

    @Column(name = "furnished", nullable = false)
    private boolean furnished;

    @Column(name = "pet_friendly", nullable = false)
    private boolean petFriendly;

    @Column(name = "suggested_value_for_rent")
    @Enumerated(EnumType.STRING)
    private SuggestedValueForRentEnum suggestedValueForRent;

    @Column(name = "suggested_value_for_sale")
    @Enumerated(EnumType.STRING)
    private SuggestedValueForSaleEnum suggestedValueForSale;

    @Column(name = "suggested_value_for_seasonal")
    @Enumerated(EnumType.STRING)
    private SuggestedValueForSeasonalEnum suggestedValueForSeasonal;

    @OneToOne
    @JoinColumn(name = "demand_id", referencedColumnName = "id")
    private Demand demand;

    @OneToOne
    @JoinColumn(name = "address_id", referencedColumnName = "id")
    private Address address;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id", referencedColumnName = "id", nullable = false)
    private User user;

    public static PropertyDemand createPropertyDemand(PropertyDemandRequest propertyDemandRequest) {
        return PropertyDemand.builder()
                .contractType(ContractTypeEnum.valueOf(propertyDemandRequest.getContract_type()))
                .propertyType(PropertyTypeEnum.valueOf(propertyDemandRequest.getProperty_type()))
                .bedroomsNumber(BedroomsNumberEnum.valueOf(propertyDemandRequest.getBedrooms_number()))
                .furnished(Boolean.parseBoolean(propertyDemandRequest.getFurnished()))
                .petFriendly(Boolean.parseBoolean(propertyDemandRequest.getPet_friendly()))
                .suggestedValueForRent(SuggestedValueForRentEnum.valueOf(propertyDemandRequest.getSuggested_value_for_rent()))
                .suggestedValueForSale(StringUtils.isEmpty(propertyDemandRequest.getSuggested_value_for_sale())
                        ? null
                        : SuggestedValueForSaleEnum.valueOf(propertyDemandRequest.getSuggested_value_for_sale()))
                .suggestedValueForSeasonal(StringUtils.isEmpty(propertyDemandRequest.getSuggested_value_for_seasonal())
                        ? null
                        : SuggestedValueForSeasonalEnum.valueOf(propertyDemandRequest.getSuggested_value_for_seasonal()))
                .build();
    }
}
