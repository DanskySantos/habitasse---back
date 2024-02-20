package com.project.habitasse.domain.propertyDemand.repository;


import com.project.habitasse.domain.propertyDemand.entities.PropertyDemand;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PropertyDemandRepository extends JpaRepository<PropertyDemand, Long> {
}
