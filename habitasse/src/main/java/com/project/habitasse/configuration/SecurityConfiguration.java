package com.project.habitasse.configuration;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.authentication.logout.LogoutHandler;
import org.springframework.web.cors.CorsConfiguration;

import static com.project.habitasse.security.roles.entity.Permission.*;
import static com.project.habitasse.security.roles.entity.Role.USER_CD;
import static com.project.habitasse.security.roles.entity.Role.USER_CO;
import static org.springframework.http.HttpMethod.*;
import static org.springframework.security.config.http.SessionCreationPolicy.STATELESS;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
@EnableMethodSecurity
public class SecurityConfiguration {

    private static final String[] WHITE_LIST_URL =
            {
                    "/api/v1/auth/**",
                    "/swagger-resources",
                    "/swagger-resources/**",
                    "/configuration/ui",
                    "/configuration/security",
                    "/swagger-ui/**",
                    "/webjars/**",
                    "/h2-console/**",
                    "/swagger-ui.html"
            };
    private final JwtAuthenticationFilter jwtAuthFilter;
    private final AuthenticationProvider authenticationProvider;
    private final LogoutHandler logoutHandler;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
//                .headers(headers -> headers.frameOptions(HeadersConfigurer.FrameOptionsConfig::disable))

                .cors(cors -> cors.configurationSource(request -> {
                    CorsConfiguration config = new CorsConfiguration();
//                    config.addAllowedOrigin("http://localhost:4200");
                    config.addAllowedOrigin("*");
                    config.addAllowedHeader("*");
                    config.addAllowedMethod("*");
                    return config;
                }))

//                .csrf(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests(req ->
                        req.requestMatchers(WHITE_LIST_URL).permitAll()
                                .requestMatchers("/api/v1/management/**" ).hasAnyRole(USER_CO.name(), USER_CD.name())
                                .requestMatchers(GET, "/api/v1/management/**" ).hasAnyAuthority(USER_READ.name(), USER_CD.name())
                                .requestMatchers(POST, "/api/v1/management/**" ).hasAnyAuthority(USER_CREATE.name(), USER_CD.name())
                                .requestMatchers(PUT, "/api/v1/management/**" ).hasAnyAuthority(USER_UPDATE.name(), USER_CD.name())
                                .requestMatchers(DELETE, "/api/v1/management/**" ).hasAnyAuthority(USER_DELETE.name(), USER_CD.name())

                                .requestMatchers(GET, "/api/v1/management/**" ).hasAnyAuthority(USER_READ.name(), USER_CO.name())
                                .requestMatchers(POST, "/api/v1/management/**" ).hasAnyAuthority(USER_CREATE.name(), USER_CO.name())
                                .requestMatchers(PUT, "/api/v1/management/**" ).hasAnyAuthority(USER_UPDATE.name(), USER_CO.name())
                                .requestMatchers(DELETE, "/api/v1/management/**" ).hasAnyAuthority(USER_DELETE.name(), USER_CO.name())
                                .anyRequest()
                                .authenticated()
                )
                .sessionManagement(session -> session.sessionCreationPolicy(STATELESS))
                .authenticationProvider(authenticationProvider)
                .addFilterBefore(jwtAuthFilter, UsernamePasswordAuthenticationFilter.class)
                .logout(logout ->
                        logout.logoutUrl("/api/v1/auth/logout" )
                                .addLogoutHandler(logoutHandler)
                                .logoutSuccessHandler((request, response, authentication) -> SecurityContextHolder.clearContext())
                )
        ;

        return http.build();
    }
}
