package com.project.habitasse.domain.offer.service;

import com.project.habitasse.domain.demand.repository.DemandRepository;
import com.project.habitasse.domain.offer.entities.Offer;
import com.project.habitasse.domain.offer.entities.request.OfferRequest;
import com.project.habitasse.domain.offer.repository.OfferRepository;
import com.project.habitasse.security.service.JwtService;
import com.project.habitasse.security.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OfferService {

    private final OfferRepository offerRepository;
    private final UserRepository userRepository;
    private final DemandRepository demandRepository;
    private final JwtService jwtService;

    public Offer saveOffer(OfferRequest offerRequest, String token) {
        offerRequest.setUser(userRepository.findByEmail(jwtService.getEmail(token)).orElseThrow());
        offerRequest.setDemand(demandRepository.findById(offerRequest.getDemandId()).orElseThrow());

        Offer newOffer = Offer.createOffer(offerRequest);

        return offerRepository.save(newOffer);
    }

//    public void deleteById(Integer propertyId, Integer demandId) {
//        PropertyDemand propertyDemand = new PropertyDemand();
//        Demand demand = new Demand();
//
//        if(propertyId != null)
//            propertyDemand = propertyDemandRepository.findById(Long.valueOf(propertyId)).get();
//        if(demandId != null)
//            demand = demandRepository.findById(Long.valueOf(demandId)).get();
//
//        Demand.delete(demand);
//        PropertyDemand.delete(propertyDemand);
//        propertyDemandRepository.save(propertyDemand);
//        demandRepository.save(demand);
//    }
}
