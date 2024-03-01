package com.project.habitasse.domain.propertyDemand.entities.request;

import com.project.habitasse.domain.enums.*;
import com.project.habitasse.domain.propertyDemand.entities.PropertyDemand;
import com.project.habitasse.security.user.entities.User;
import com.project.habitasse.security.user.entities.request.UserRequest;
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

    public static PropertyDemand mapRequestToDemand(PropertyDemandRequest DemandRequest) {
        PropertyDemand propertyDemand = new PropertyDemand();
        propertyDemand.setId(Math.toIntExact(DemandRequest.getId()));
        propertyDemand.setContractType(ContractTypeEnum.valueOf(DemandRequest.getContract_type()));
        propertyDemand.setPropertyType(PropertyTypeEnum.valueOf(DemandRequest.getProperty_type()));
        propertyDemand.setBedroomsNumber(BedroomsNumberEnum.valueOf(DemandRequest.getBedrooms_number()));
        propertyDemand.setFurnished(Boolean.parseBoolean(DemandRequest.getFurnished()));
        propertyDemand.setPetFriendly(Boolean.parseBoolean(DemandRequest.getPet_friendly()));
        propertyDemand.setSuggestedValueForRent(SuggestedValueForRentEnum.valueOf(DemandRequest.getSuggested_value_for_rent()));
        propertyDemand.setSuggestedValueForSale(SuggestedValueForSaleEnum.valueOf(DemandRequest.getSuggested_value_for_sale()));
        propertyDemand.setSuggestedValueForSeasonal(SuggestedValueForSeasonalEnum.valueOf(DemandRequest.getSuggested_value_for_seasonal()));
        return propertyDemand;
    }
}
