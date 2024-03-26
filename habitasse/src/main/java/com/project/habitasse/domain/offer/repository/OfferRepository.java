package com.project.habitasse.domain.offer.repository;


import com.project.habitasse.domain.offer.entities.Offer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OfferRepository extends JpaRepository<Offer, Long> {
}
