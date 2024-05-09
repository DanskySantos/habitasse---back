package com.project.habitasse.domain.demand.resource;

import com.project.habitasse.domain.demand.service.DemandService;
import com.project.habitasse.domain.propertyDemand.entities.request.PropertyDemandRequest;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/demand")
@RequiredArgsConstructor
public class DemandController {

    private final DemandService demandService;

    @GetMapping("/findByEmail/{page}/{size}")
    public ResponseEntity<?> getByUserEmail(HttpServletRequest request,
                                            @PathVariable Integer page,
                                            @PathVariable Integer size) {
        if (request.getHeader("Authorization") == null)
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Erro inesperado");

        Pageable paging = PageRequest.of(page, size);
        return ResponseEntity.ok(demandService.getByUserEmail(request.getHeader("Authorization"), paging));
    }

    @PostMapping("/filter/{page}/{size}")
    public ResponseEntity<?> getFilteredDemands(@PathVariable Integer page,
                                                @PathVariable Integer size,
                                                @RequestBody PropertyDemandRequest propertyDemandRequest,
                                                HttpServletRequest request) {
        Pageable paging = PageRequest.of(page, size);
        return ResponseEntity.ok(demandService.getFilteredDemands(paging, propertyDemandRequest, request.getHeader("Authorization")));
    }

}

