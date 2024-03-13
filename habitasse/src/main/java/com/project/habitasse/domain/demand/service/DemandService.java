package com.project.habitasse.domain.demand.service;

import com.project.habitasse.domain.address.repository.AddressRepository;
import com.project.habitasse.domain.demand.entities.Demand;
import com.project.habitasse.domain.demand.repository.DemandRepository;
import com.project.habitasse.domain.propertyDemand.repository.PropertyDemandRepository;
import com.project.habitasse.security.service.JwtService;
import com.project.habitasse.security.user.entities.User;
import com.project.habitasse.security.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class DemandService {


    private final PropertyDemandRepository propertyDemandRepository;
    private final DemandRepository demandRepository;
    private final AddressRepository addressRepository;
    private final UserRepository userRepository;
    private final JwtService jwtService;

    public Optional<List<Demand>> getByUserEmail(String token) {
        User user = userRepository.findByEmail(jwtService.getEmail(token)).orElseThrow();

        return demandRepository.getByUserEmail(user.getId());
    }
}
