package com.project.habitasse.domain.demand.repository;


import com.project.habitasse.domain.demand.entities.Demand;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface DemandRepository extends JpaRepository<Demand, Long> {

    @Query(value = "SELECT * FROM tb_demand WHERE user_id = :userId AND is_deleted = false", nativeQuery = true)
    Optional<List<Demand>> getByUserEmail(@Param("userId") Integer userId);
}
