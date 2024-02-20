package com.project.habitasse.security.user.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {

    @Value("${custom.auth.token}")
    private String authToken;

    public String getAuthToken() {
        return "Bearer " + authToken;
    }
}
