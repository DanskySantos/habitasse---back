package com.project.habitasse.domain.offer.service;

import com.project.habitasse.domain.demand.entities.Demand;
import com.project.habitasse.domain.demand.repository.DemandRepository;
import com.project.habitasse.domain.offer.entities.Offer;
import com.project.habitasse.domain.offer.entities.request.OfferRequest;
import com.project.habitasse.domain.offer.repository.OfferRepository;
import com.project.habitasse.security.service.JwtService;
import com.project.habitasse.security.user.entities.User;
import com.project.habitasse.security.user.repository.UserRepository;
import com.project.habitasse.shared.mail.EmailService;
import jakarta.mail.MessagingException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class OfferService {

    private final OfferRepository offerRepository;
    private final UserRepository userRepository;
    private final DemandRepository demandRepository;
    private final JwtService jwtService;
    private final EmailService emailService;

    private Map<String, Object> createEmailVariables(String userName) {
        Map<String, Object> variables = new HashMap<>();
        variables.put("userName", userName);
        return variables;
    }

    public Offer saveOffer(OfferRequest offerRequest, String token) throws Exception {
        Demand demand = demandRepository.findById(offerRequest.getDemandId()).orElseThrow();
        Map<String, Object> variables = this.createEmailVariables(demand.getUser().getUsername());
        try {
            User user = userRepository.findByEmailAndExcludedFalse(jwtService.getEmail(token)).orElseThrow();

            if (demand.getOffers().stream().anyMatch(offer -> Objects.equals(offer.getUserId(), user.getId())))
                throw new Exception("Já existe uma oferta cadastrada");

            offerRequest.setUser(user);
            offerRequest.setDemand(demand);
            offerRequest.setContact(user.getPerson().getPhone());
            Offer newOffer = Offer.createOffer(offerRequest);
            Offer offerToReturn = offerRepository.save(newOffer);

            emailService.sendEmail(demand.getUser().getEmail(), "Nova proposta!", "new-offer-email", variables);
            return offerToReturn;
        } catch (MessagingException e) {
            System.out.printf("Failed to send email to " + variables.get("userName") + " with error: " + e.getMessage());
        }
        return null;
    }

    public Offer updateOffer(Long id, OfferRequest offerRequest) throws Exception {
        Offer offer = offerRepository.findById(id).orElseThrow();

        if (StringUtils.isEmpty(offerRequest.getText()))
            throw new Exception("O texto não pode ser nulo");

        return offerRepository.save(Offer.updateOffer(offer, offerRequest));
    }

    public Page<Offer> getByDemand(Integer demandId, Pageable pageable) {
        Demand demand = demandRepository.findById(Long.valueOf(demandId)).orElseThrow();

        return offerRepository.getOfferByDemandAndDeletedFalse(demand, pageable);
    }

    @Transactional
    public void acceptOffer(Integer id) {
        Offer offer = offerRepository.findById(Long.valueOf(id)).orElseThrow();
        Offer.acceptedOffer(offer);

        offerRepository.save(offer);
    }

    @Transactional
    public void deleteOfferById(Integer offerId) {
        Offer offer = offerRepository.findById(Long.valueOf(offerId)).orElseThrow();
        Offer.delete(offer);

        offerRepository.save(offer);
    }
}
