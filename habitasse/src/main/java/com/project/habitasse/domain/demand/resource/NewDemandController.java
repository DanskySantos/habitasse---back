package com.project.habitasse.domain.demand.resource;

import com.project.habitasse.domain.address.service.AddressService;
import com.project.habitasse.domain.propertyDemand.entities.request.PropertyDemandRequest;
import com.project.habitasse.domain.propertyDemand.service.PropertyDemandService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/new-demand")
@RequiredArgsConstructor
public class NewDemandController {

    private final PropertyDemandService propertyDemandService;
    private final AddressService addressService;

    @GetMapping("/states")
    public ResponseEntity<?> getStates() {
        return ResponseEntity.ok(addressService.findAll());
    }

    @GetMapping("/filter-cities/{stateName}")
    public ResponseEntity<?> getFilteredCities(@PathVariable String stateName) {
        return ResponseEntity.ok(addressService.filterCities(stateName));
    }

    @PostMapping("/save")
    public ResponseEntity<?> registerNewDemand(@RequestBody PropertyDemandRequest propertyDemandRequest) {
        if (propertyDemandRequest == null)
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Dados inválidos");

        return ResponseEntity.ok(propertyDemandService.registerNewDemand(propertyDemandRequest));
    }
}

