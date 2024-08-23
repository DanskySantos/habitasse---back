package com.project.habitasse.configuration;

import com.project.habitasse.security.service.JwtService;
import com.project.habitasse.security.token.repository.TokenRepository;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
@RequiredArgsConstructor
public class JwtAuthenticationFilter extends OncePerRequestFilter {

    private final JwtService jwtService;
    private final UserDetailsService userDetailsService;
    private final TokenRepository tokenRepository;

    @Value("${oauth.client.name}")
    private String clientId;

    @Value("${oauth.client.secret}")
    private String clientSecret;

    @Override
    protected void doFilterInternal(
            @NonNull HttpServletRequest request,
            @NonNull HttpServletResponse response,
            @NonNull FilterChain filterChain) throws ServletException, IOException {
        final String authHeader = request.getHeader("Authorization");
        final String jwt;
        final String userEmail;

        if (request.getServletPath().contains("/api/v1/auth") || request.getServletPath().contains("/api/v1/new-demand")) {
            if (authHeader == null || !authHeader.startsWith("Basic ")) {
                response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
                return;
            }

            String encodedCredentials = authHeader.substring(6).trim();
            String decodedCredentials = new String(java.util.Base64.getDecoder().decode(encodedCredentials));
            String[] credentialsArray = decodedCredentials.split(":");

            if (credentialsArray.length != 2 || !credentialsArray[0].equals(clientId) || !credentialsArray[1].equals(clientSecret)) {
                response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
                return;
            }
            filterChain.doFilter(request, response);
            return;
        }

        if (authHeader == null || !authHeader.startsWith("Bearer ")) {
            filterChain.doFilter(request, response);
            return;
        }

        jwt = authHeader.substring(7);
        userEmail = jwtService.extractUsername(jwt);

        if (userEmail != null && SecurityContextHolder.getContext().getAuthentication() == null) {
            UserDetails userDetails = this.userDetailsService.loadUserByUsername(userEmail);

            //TODO implement here the logic to expirationDate and authorizationDate

            var isTokenValid = tokenRepository.findByToken(jwt)
                    .map(t -> !t.isExpired() && !t.isRevoked())
                    .orElse(false);

            if (jwtService.isTokenValid(jwt, userDetails) && isTokenValid) {
                UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(
                        userDetails,
                        null,
                        userDetails.getAuthorities()
                );
                authToken.setDetails(
                        new WebAuthenticationDetailsSource().buildDetails(request)
                );
                SecurityContextHolder.getContext().setAuthentication(authToken);
            }
        }
        filterChain.doFilter(request, response);
    }
}
