package com.project.habitasse.domain.propertyDemand.repository;


import com.project.habitasse.domain.propertyDemand.entities.PropertyDemand;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PropertyDemandRepository extends JpaRepository<PropertyDemand, Long> {
    Optional<List<PropertyDemand>> findAllByEmail(String email);
}
