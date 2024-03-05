package com.project.habitasse.domain.address.resource;

import com.project.habitasse.domain.address.entities.request.AddressRequest;
import com.project.habitasse.domain.address.service.AddressService;
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

//    @PostMapping("/save")
//    public ResponseEntity<?> save(@RequestBody AddressRequest addressRequest) throws Exception {
//        if (userService.findByEmail(registerRequest.getEmail()).isPresent())
//            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Já existe um usuário cadastrado com esse e-mail");
//
//        if (registerRequest.getUserRoles() == null)
//            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Role não pode ser nula");
//
//        return ResponseEntity.ok(userService.register(registerRequest));
//    }
}

