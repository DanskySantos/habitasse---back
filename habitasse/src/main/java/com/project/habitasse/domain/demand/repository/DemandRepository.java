package com.project.habitasse.domain.demand.repository;


import com.project.habitasse.domain.demand.entities.Demand;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DemandRepository extends JpaRepository<Demand, Long> {
}
