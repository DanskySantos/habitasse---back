package com.project.habitasse.domain.offer.entities.request;

import com.project.habitasse.domain.demand.entities.Demand;
import com.project.habitasse.security.user.entities.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OfferRequest {

    private Integer id;
    private Long demandId;
    private Integer userId;
    private Demand demand;
    private User user;
    private String text;
    private String contact;
    private List<FileRequest> files;
}
