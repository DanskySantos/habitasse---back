package com.project.habitasse.domain.address.resource;

import com.project.habitasse.domain.address.service.AddressService;
import com.project.habitasse.domain.propertyDemand.entities.request.PropertyDemandRequest;
import com.project.habitasse.domain.propertyDemand.service.PropertyDemandService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/address")
@RequiredArgsConstructor
public class AddressController {

    private final AddressService addressService;

    @GetMapping("/states")
    public ResponseEntity<?> getStates() {
        return ResponseEntity.ok(addressService.findAll());
    }

    @GetMapping("/filter-cities/{stateName}")
    public ResponseEntity<?> getFilteredCities(@PathVariable String stateName) {
        return ResponseEntity.ok(addressService.filterCities(stateName));
    }

//    @GetMapping("/findByEmail/{email}")
//    public ResponseEntity<List<PropertyDemand>> findByEmail(@PathVariable String email) {
//        Optional<List<PropertyDemand>> propertyDemands = propertyDemandService.findByEmail(email);
//        if (propertyDemands.isPresent()) {
//            return new ResponseEntity<>(propertyDemands.get(), HttpStatus.OK);
//        } else {
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//        }
//    }

}

