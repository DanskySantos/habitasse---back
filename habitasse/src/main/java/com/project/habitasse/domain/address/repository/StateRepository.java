package com.project.habitasse.domain.address.repository;


import com.project.habitasse.domain.address.entities.City;
import com.project.habitasse.domain.address.entities.State;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface StateRepository extends JpaRepository<State, Long> {

    Optional<State> findByNome(String nome);
}
