package com.project.habitasse.domain.offer.repository;


import com.project.habitasse.domain.offer.entities.Offer;
import com.project.habitasse.security.user.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface OfferRepository extends JpaRepository<Offer, Long> {
}
