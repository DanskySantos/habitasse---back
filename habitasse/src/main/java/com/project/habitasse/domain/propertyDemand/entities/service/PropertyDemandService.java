package com.project.habitasse.domain.propertyDemand.entities.service;

import com.project.habitasse.domain.propertyDemand.entities.PropertyDemand;
import com.project.habitasse.domain.propertyDemand.entities.request.RegisterRequestDemand;
import com.project.habitasse.domain.propertyDemand.repository.PropertyDemandRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PropertyDemandService{


    private final PropertyDemandRepository propertyDemandRepository;

    public PropertyDemand registerDemand(RegisterRequestDemand registerRequestDemand) {
        PropertyDemand newPropertyDemand = PropertyDemand.createDemand(registerRequestDemand);
        return propertyDemandRepository.save(newPropertyDemand);
    }

    public Optional<List<PropertyDemand>> findByEmail(String email) {
        return propertyDemandRepository.findAllByEmail(email);
    }
}
