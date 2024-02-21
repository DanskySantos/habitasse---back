package com.project.habitasse.security.user.resource;

import com.project.habitasse.security.user.entities.request.AuthenticationRequest;
import com.project.habitasse.security.user.entities.response.LoginResponse;
import com.project.habitasse.security.user.entities.response.UserResponse;
import com.project.habitasse.security.user.repository.UserRepository;
import com.project.habitasse.security.user.service.JwtTokenProvider;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthLoginController {

    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private JwtTokenProvider tokenService;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody @Valid AuthenticationRequest authenticationRequest) {
        try {
            UsernamePasswordAuthenticationToken usernamePassword = new UsernamePasswordAuthenticationToken(authenticationRequest.email(), authenticationRequest.password());
            Authentication auth = authenticationManager.authenticate(usernamePassword);
            var token = tokenService.generateToken((UserResponse) auth.getPrincipal());
            return ResponseEntity.ok(new LoginResponse(token, "username"));
        } catch (AuthenticationException e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Falha na Autenticação!");
        }
    }

//    @PostMapping("/login")
//    public ResponseEntity<?> authenticateUser(@RequestBody AuthenticationRequest loginForm) {
//        try {
//            Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginForm.getUsername(), loginForm.getPassword()));
//
//            SecurityContextHolder.getContext().setAuthentication(authentication);
//
//            String token = jwtTokenProvider.generateToken(authentication);
//            return ResponseEntity.ok(new LoginDto(loginForm.getUsername(), loginForm.getPassword(), token));
//        } catch (AuthenticationException e) {
//            // Log the exception details
//            System.out.print(e.getMessage());
//            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Authentication failed");
//        }
//    }

//    @PostMapping("/register")
//    public ResponseEntity register(@RequestBody @Valid RegisterRequest data){
//        if(this.repository.findByEmail(data.email()) != null) return ResponseEntity.badRequest().body("E-mail already registered");
//        String encryptedPassword = new BCryptPasswordEncoder().encode(data.password());
//        Usuario newUser = new Usuario(data.name(), data.email(), encryptedPassword, data.role(), data.avatarImg());
//        this.repository.save(newUser);
//        return ResponseEntity.ok().body("User registered successfully");
//    }

}
