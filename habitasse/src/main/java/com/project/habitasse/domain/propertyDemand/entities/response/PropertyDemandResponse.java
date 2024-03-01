package com.project.habitasse.domain.propertyDemand.entities.response;

import com.project.habitasse.domain.propertyDemand.entities.request.PropertyDemandRequest;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PropertyDemandResponse {
    private Integer id;
    private String contract_type;
    private String property_type;
    private String bedrooms_number;
    private String furnished;
    private String pet_friendly;
    private String suggested_value_for_rent;
    private String suggested_value_for_sale;
    private String suggested_value_for_seasonal;

    public static PropertyDemandResponse mapResponseDemand(PropertyDemandRequest demandRequest){
        return PropertyDemandResponse.builder()
                .contract_type(demandRequest.getContract_type())
                .property_type(demandRequest.getProperty_type())
                .bedrooms_number(demandRequest.getBedrooms_number())
                .furnished(demandRequest.getFurnished())
                .pet_friendly(demandRequest.getPet_friendly())
                .suggested_value_for_rent(demandRequest.getSuggested_value_for_rent())
                .suggested_value_for_sale(demandRequest.getSuggested_value_for_sale())
                .suggested_value_for_seasonal(demandRequest.getSuggested_value_for_seasonal())
                .build();
    }
}
