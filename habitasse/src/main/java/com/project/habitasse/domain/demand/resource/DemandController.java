package com.project.habitasse.domain.demand.resource;

import com.project.habitasse.domain.demand.service.DemandService;
import com.project.habitasse.domain.propertyDemand.entities.request.PropertyDemandRequest;
import com.project.habitasse.domain.propertyDemand.service.PropertyDemandService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/demand")
@RequiredArgsConstructor
public class DemandController {

    private final DemandService demandService;

    @GetMapping("/findByEmail")
    public ResponseEntity<?> getByUserEmail(HttpServletRequest request) {
        if (request.getHeader("Authorization") == null)
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Erro inesperado");

        return ResponseEntity.ok(demandService.getByUserEmail(request.getHeader("Authorization")));
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

