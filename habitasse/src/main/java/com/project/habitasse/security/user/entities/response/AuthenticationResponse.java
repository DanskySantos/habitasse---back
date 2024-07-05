package com.project.habitasse.security.user.entities.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AuthenticationResponse {

    @JsonProperty("access_token")
    private String accessToken;

    @JsonProperty("refresh_token")
    private String refreshToken;

    @JsonProperty("username")
    private String userName;

    @JsonProperty("userId")
    private Integer userId;

    @JsonProperty("userRole")
    private String userRole;

    @JsonProperty("remainingDays")
    private Long remainingDays;

    @JsonProperty("isAccountConfirmed")
    private Boolean isAccountConfirmed;
}
