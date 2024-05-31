package com.project.habitasse.security.user.resource;

import com.project.habitasse.security.user.entities.request.AuthenticationRequest;
import com.project.habitasse.security.user.entities.request.RegisterRequest;
import com.project.habitasse.security.user.service.UserService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthLoginController {

    private final UserService userService;

    @PostMapping("/authenticate")
    public ResponseEntity<?> authenticate(@RequestBody AuthenticationRequest request) {
        var authenticationResponse = userService.authenticate(request);
        if (userService.findByEmail(request.getEmail()).isEmpty())
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Não existe um usuário com esse e-mail");

        if (authenticationResponse.getStatusCode() == HttpStatus.BAD_REQUEST)
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Senha Incorreta");

        return ResponseEntity.ok(authenticationResponse);
    }

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody RegisterRequest registerRequest) {
        if (userService.findByEmail(registerRequest.getEmail()).isPresent())
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Já existe um usuário cadastrado com esse e-mail");

        if (registerRequest.getUserRoles() == null)
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Role não pode ser nula");

        return ResponseEntity.ok(userService.register(registerRequest));
    }

    @PostMapping("/refresh-token")
    public void refreshToken(HttpServletRequest request, HttpServletResponse response) throws IOException {
        userService.refreshToken(request, response);
    }
}
