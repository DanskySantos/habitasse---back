package com.project.habitasse.domain.offer.repository;


import com.project.habitasse.domain.demand.entities.Demand;
import com.project.habitasse.domain.offer.entities.Offer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface OfferRepository extends JpaRepository<Offer, Long> {

    Page<Offer> getOfferByDemand(Demand demand, Pageable pageable);
}
