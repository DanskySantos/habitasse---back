package com.project.habitasse.domain.demand.service;

import com.project.habitasse.domain.demand.entities.Demand;
import com.project.habitasse.domain.demand.repository.DemandRepository;
import com.project.habitasse.domain.enums.*;
import com.project.habitasse.domain.propertyDemand.entities.request.PropertyDemandRequest;
import com.project.habitasse.domain.propertyDemand.repository.PropertyDemandRepository;
import com.project.habitasse.security.service.JwtService;
import com.project.habitasse.security.user.entities.User;
import com.project.habitasse.security.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.apache.commons.lang3.StringUtils;

import java.util.Objects;

@Service
@RequiredArgsConstructor
public class DemandService {

    private final DemandRepository demandRepository;
    private final UserRepository userRepository;
    private final PropertyDemandRepository propertyDemandRepository;
    private final JwtService jwtService;

    public Page<Demand> getByUserEmail(String token, Pageable pageable) {
        User user = userRepository.findByEmail(jwtService.getEmail(token)).orElseThrow();

        return demandRepository.getByUserEmail(user.getId(), pageable);
    }

    public Page<Demand> getFilteredDemands(Pageable pageable, PropertyDemandRequest propertyDemandRequest) {

        return propertyDemandRepository.getFilteredDemands(
                StringUtils.isEmpty(propertyDemandRequest.getContractType()) ? null : ContractTypeEnum.getByDescription(propertyDemandRequest.getContractType()),
                StringUtils.isEmpty(propertyDemandRequest.getPropertyType()) ? null : PropertyTypeEnum.getByDescription(propertyDemandRequest.getPropertyType()),
                StringUtils.isEmpty(propertyDemandRequest.getBedroomsNumber()) ? null : BedroomsNumberEnum.getByDescription(propertyDemandRequest.getBedroomsNumber()),
                StringUtils.isEmpty(propertyDemandRequest.getFurnished()) ? null : Objects.equals(propertyDemandRequest.getFurnished().toLowerCase(), "sim"),
                StringUtils.isEmpty(propertyDemandRequest.getPetFriendly()) ? null : Objects.equals(propertyDemandRequest.getPetFriendly().toLowerCase(), "sim"),
                StringUtils.isEmpty(propertyDemandRequest.getSuggestedValueForRent()) ? null : SuggestedValueForRentEnum.getByDescription(propertyDemandRequest.getSuggestedValueForRent()),
                StringUtils.isEmpty(propertyDemandRequest.getSuggestedValueForSale()) ? null : SuggestedValueForSaleEnum.getByDescription(propertyDemandRequest.getSuggestedValueForSale()),
                StringUtils.isEmpty(propertyDemandRequest.getSuggestedValueForSeasonal()) ? null : SuggestedValueForSeasonalEnum.getByDescription(propertyDemandRequest.getSuggestedValueForSeasonal()),
                StringUtils.isEmpty(propertyDemandRequest.getState()) ? null : propertyDemandRequest.getState(),
                StringUtils.isEmpty(propertyDemandRequest.getCity()) ? null : propertyDemandRequest.getCity(),
                pageable
        );
    }
}
