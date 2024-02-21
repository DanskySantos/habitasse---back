package com.project.habitasse.security.user.entities.request;

public record AuthenticationRequest(String email, String password) {
}
