package com.project.habitasse.domain.offer.resource;

import com.project.habitasse.domain.propertyDemand.entities.request.PropertyDemandRequest;
import com.project.habitasse.domain.propertyDemand.service.PropertyDemandService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
//
//@RestController
//@RequestMapping("/api/v1/propertyDemand")
//@RequiredArgsConstructor
//public class OfferController {
//
//    private final PropertyDemandService propertyDemandService;
//
//    @PostMapping("/save")
//    public ResponseEntity<?> registerDemand(@RequestBody PropertyDemandRequest propertyDemandRequest, HttpServletRequest request) {
//        if (propertyDemandRequest == null)
//            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Dados inválidos");
//
//        return ResponseEntity.ok(propertyDemandService.registerDemand(propertyDemandRequest, request.getHeader("Authorization")));
//    }
//
//    @DeleteMapping("/delete/{propertyId}/{demandId}")
//    public ResponseEntity<?> deletePropertyDemand(@PathVariable("propertyId") Integer propertyId,
//                                                  @PathVariable("demandId") Integer demandId) {
//        if (propertyId == null && demandId == null)
//            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Dados inválidos");
//
//        propertyDemandService.deleteById(propertyId, demandId);
//        return ResponseEntity.ok(HttpStatus.OK);
//    }
//
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
//}
//
