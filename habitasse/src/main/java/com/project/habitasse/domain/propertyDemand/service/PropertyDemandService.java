package com.project.habitasse.domain.propertyDemand.service;

import com.project.habitasse.domain.address.entities.Address;
import com.project.habitasse.domain.address.repository.AddressRepository;
import com.project.habitasse.domain.demand.entities.Demand;
import com.project.habitasse.domain.demand.repository.DemandRepository;
import com.project.habitasse.domain.propertyDemand.entities.PropertyDemand;
import com.project.habitasse.domain.propertyDemand.entities.request.PropertyDemandRequest;
import com.project.habitasse.domain.propertyDemand.repository.PropertyDemandRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PropertyDemandService{


    private final PropertyDemandRepository propertyDemandRepository;
    private final DemandRepository demandRepository;
    private final AddressRepository addressRepository;

    public PropertyDemand registerDemand(PropertyDemandRequest propertyDemandRequest) {
        Address address = Address.createAddress(propertyDemandRequest);
        PropertyDemand newPropertyDemand = PropertyDemand.createPropertyDemand(propertyDemandRequest);

        newPropertyDemand.setAddress(address);
        propertyDemandRequest.setPropertyDemand(propertyDemandRepository.save(newPropertyDemand));

        Demand demand = Demand.createDemand(propertyDemandRequest);

        demandRepository.save(demand);
        addressRepository.save(address);

        return newPropertyDemand;
    }

//    public Optional<List<PropertyDemand>> findByEmail(String email) {
//        return propertyDemandRepository.findAllByEmail(email);
//    }
}
