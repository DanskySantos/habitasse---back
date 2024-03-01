package com.project.habitasse.domain.propertyDemand.entities.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RegisterRequestDemand {
    private Integer id;
    private String contract_type;
    private String property_type;
    private String bedrooms_number;
    private String furnished;
    private String pet_friendly;
    private String suggested_value_for_rent;
    private String suggested_value_for_sale;
    private String suggested_value_for_seasonal;
}


