package com.project.habitasse.domain.demand.service;

import com.project.habitasse.domain.demand.entities.Demand;
import com.project.habitasse.domain.demand.repository.DemandRepository;
import com.project.habitasse.security.service.JwtService;
import com.project.habitasse.security.user.entities.User;
import com.project.habitasse.security.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class DemandService {

    private final DemandRepository demandRepository;
    private final UserRepository userRepository;
    private final JwtService jwtService;

    public Page<Demand> getByUserEmail(String token, Pageable pageable) {
        User user = userRepository.findByEmail(jwtService.getEmail(token)).orElseThrow();

        return demandRepository.getByUserEmail(user.getId(), pageable);
    }

    public Page<Demand> getAll(String token, Pageable pageable) {
        User user = userRepository.findByEmail(jwtService.getEmail(token)).orElseThrow();

        return demandRepository.getByUserEmail(user.getId(), pageable);
    }
}
