package com.project.habitasse.domain.offer.entities.response;

import com.project.habitasse.domain.demand.entities.Demand;
import com.project.habitasse.security.user.entities.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OfferResponse {

    private Integer id;
    private Long demandId;
    private Integer userId;
    private Demand demand;
    private User user;
    private String text;
}
