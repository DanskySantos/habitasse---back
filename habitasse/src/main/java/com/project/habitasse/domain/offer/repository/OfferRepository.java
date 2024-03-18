package com.project.habitasse.domain.offer.repository;


import com.project.habitasse.domain.offer.entities.Offer;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OfferRepository extends PagingAndSortingRepository<Offer, Long> {
}
