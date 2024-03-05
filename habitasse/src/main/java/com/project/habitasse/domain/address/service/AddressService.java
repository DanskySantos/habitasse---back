package com.project.habitasse.domain.address.service;

import com.project.habitasse.domain.address.entities.City;
import com.project.habitasse.domain.address.entities.State;
import com.project.habitasse.domain.address.repository.AddressRepository;
import com.project.habitasse.domain.address.repository.CityRepository;
import com.project.habitasse.domain.address.repository.StateRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AddressService {

    private final AddressRepository addressRepository;
    private final StateRepository stateRepository;
    private final CityRepository cityRepository;

    public List<State> findAll() {
        return stateRepository.findAll();
    }

    public Optional<List<City>> filterCities(String stateName) {
        var state = stateRepository.findByNome(stateName).get();
        return cityRepository.findAllByUf(state.getId());
    }
}
