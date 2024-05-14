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
    private String contractType;
    private String propertyType;
    private String bedroomsNumber;
    private String furnished;
    private String petFriendly;
    private String suggestedValueForRent;
    private String suggestedValueForSale;
    private String suggestedValueForSeasonal;
    private String country;
    private String state;
    private String city;
    private String annotation;
    private String contact;
    private PropertyDemand propertyDemand;
    private Boolean userId;
}
