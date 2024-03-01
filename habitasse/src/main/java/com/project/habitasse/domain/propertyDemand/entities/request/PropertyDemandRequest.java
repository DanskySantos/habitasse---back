package com.project.habitasse.domain.propertyDemand.entities.request;

import com.project.habitasse.domain.propertyDemand.entities.PropertyDemand;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PropertyDemandRequest {

    private Integer id;
    private String contract_type;
    private String property_type;
    private String bedrooms_number;
    private String furnished;
    private String pet_friendly;
    private String suggested_value_for_rent;
    private String suggested_value_for_sale;
    private String suggested_value_for_seasonal;
    private String country;
    private String state;
    private String city;
    private String comments;
    private String contact;
    private PropertyDemand propertyDemand;
}
