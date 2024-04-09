package com.project.habitasse.domain.offer.service;

import com.project.habitasse.domain.demand.entities.Demand;
import com.project.habitasse.domain.demand.repository.DemandRepository;
import com.project.habitasse.domain.offer.entities.Offer;
import com.project.habitasse.domain.offer.entities.request.OfferRequest;
import com.project.habitasse.domain.offer.repository.OfferRepository;
import com.project.habitasse.security.service.JwtService;
import com.project.habitasse.security.user.entities.User;
import com.project.habitasse.security.user.repository.UserRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
@RequiredArgsConstructor
public class OfferService {

    private final OfferRepository offerRepository;
    private final UserRepository userRepository;
    private final DemandRepository demandRepository;
    private final JwtService jwtService;

    public Offer saveOffer(OfferRequest offerRequest, String token) throws Exception {
        User user = userRepository.findByEmail(jwtService.getEmail(token)).orElseThrow();
        Demand demand = demandRepository.findById(offerRequest.getDemandId()).orElseThrow();

        if (demand.getOffers().stream().anyMatch(offer -> Objects.equals(offer.getUserId(), user.getId())))
            throw new Exception("Já existe uma oferta cadastrada");

        offerRequest.setUser(user);
        offerRequest.setDemand(demand);
        offerRequest.setContact(user.getPerson().getPhone());

        Offer newOffer = Offer.createOffer(offerRequest);

        return offerRepository.save(newOffer);
    }

    public Offer updateOffer(Long id, OfferRequest offerRequest) throws Exception {
        Offer offer = offerRepository.findById(id).orElseThrow();
        if (StringUtils.isEmpty(offerRequest.getText()))
            throw new Exception("O texto não pode ser nulo");

        return offerRepository.save(Offer.updateOffer(offer, offerRequest));
    }

    public Page<Offer> getByDemand(Integer demandId, Pageable pageable) {
        Demand demand = demandRepository.findById(Long.valueOf(demandId)).orElseThrow();

        return offerRepository.getOfferByDemand(demand, pageable);
    }

    @Transactional
    public Offer acceptOffer(Long id) throws Exception {
        Offer offer = offerRepository.findById(id).orElseThrow();
        if (offer.isAccepted())
            throw new Exception("Oferta com id " + id + " já foi aceita");

        offer.setAccepted(true);
        return offerRepository.save(offer);
    }
}
