package com.project.habitasse.domain.address.repository;


import com.project.habitasse.domain.address.entities.City;
import com.project.habitasse.domain.propertyDemand.entities.PropertyDemand;
import com.project.habitasse.security.user.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CityRepository extends JpaRepository<City, Long> {

    Optional<List<City>> findAllByUf(Integer uf);
}
