package com.project.habitasse.domain.propertyDemand.resource;

import com.project.habitasse.domain.propertyDemand.entities.PropertyDemand;
import com.project.habitasse.domain.propertyDemand.entities.request.PropertyDemandRequest;
import com.project.habitasse.domain.propertyDemand.service.PropertyDemandService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/register-demand")
@RequiredArgsConstructor
public class PropertyDemandController {

    private final PropertyDemandService propertyDemandService;

    @PostMapping("/save")
    public ResponseEntity<?> registerDemand(@RequestBody PropertyDemandRequest propertyDemandRequest, HttpServletRequest request) {
        if (propertyDemandRequest == null)
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Dados inválidos");

        return ResponseEntity.ok(propertyDemandService.registerDemand(propertyDemandRequest, request.getHeader("Authorization")));
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

