package com.project.habitasse.domain.propertyDemand.entities.controller;

import com.project.habitasse.domain.propertyDemand.entities.PropertyDemand;
import com.project.habitasse.domain.propertyDemand.entities.request.RegisterRequestDemand;
import com.project.habitasse.domain.propertyDemand.entities.service.PropertyDemandService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/register-demand")
@RequiredArgsConstructor
public class PropertyDemandController {

    private final PropertyDemandService propertyDemandService;

    @PostMapping("/demanda")
    public ResponseEntity<?> registerDemand(@RequestBody RegisterRequestDemand registerRequestDemand) {
        if (registerRequestDemand != null)
            return ResponseEntity.ok("Demanda registrada com sucesso!");

        return ResponseEntity.ok(propertyDemandService.registerDemand(registerRequestDemand));
    }

    @GetMapping("/findByEmail/{email}")
    public ResponseEntity<List<PropertyDemand>> findByEmail(@PathVariable String email) {
        Optional<List<PropertyDemand>> propertyDemands = propertyDemandService.findByEmail(email);
        if (propertyDemands.isPresent()) {
            return new ResponseEntity<>(propertyDemands.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}

