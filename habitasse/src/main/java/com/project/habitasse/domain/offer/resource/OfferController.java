package com.project.habitasse.domain.offer.resource;

import com.project.habitasse.domain.offer.entities.request.OfferRequest;
import com.project.habitasse.domain.offer.service.OfferService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/offer")
@RequiredArgsConstructor
public class OfferController {

    private final OfferService offerService;

    @PostMapping("/save")
    public ResponseEntity<?> registerDemand(@RequestBody OfferRequest offerRequest, HttpServletRequest request) {
        if (offerRequest.getDemandId() == null || StringUtils.isEmpty(offerRequest.getText()))
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Dados inválidos");

        return ResponseEntity.ok(offerService.saveOffer(offerRequest, request.getHeader("Authorization")));
    }

//    @PutMapping("/update/{id}")
//    public ResponseEntity<?> updatePropertyDemand(@PathVariable Long id, @RequestBody PropertyDemandRequest propertyDemandRequest) {
//        if (id == null)
//            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("ID inválido");
//
//        if (propertyDemandRequest == null)
//            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Dados inválidos");
//
//        return ResponseEntity.ok(propertyDemandService.updatePropertyDemand(id, propertyDemandRequest));
//    }
}

