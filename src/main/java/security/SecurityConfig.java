// package com.example.demo.security;

// public class SecurityConfig {
//     public boolean isSecurityEnabled() {
//         return true;
//     }
    
//     public String[] getPublicEndpoints() {
//         return new String[]{"/api/public/**"};
//     }
// }



package com.example.demo.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
public class SecurityConfig {

    private final JwtAuthenticationFilter jwtFilter;

    public SecurityConfig(JwtAuthenticationFilter jwtFilter) {
        this.jwtFilter = jwtFilter;
    }

 @Bean
public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

    http
        .csrf(csrf -> csrf.disable())
        .authorizeHttpRequests(auth -> auth

            // 🔓 PUBLIC ENDPOINTS
            .requestMatchers(
                    "/auth/**",
                    "/swagger-ui/**",
                    "/v3/api-docs/**",
                    "/health",
                    "/demo"
            ).permitAll()

            // 🔓 ALLOW USER REGISTRATION (VERY IMPORTANT)
            .requestMatchers(HttpMethod.POST, "/api/users").permitAll()

            // 🔐 EVERYTHING ELSE NEEDS JWT
            .requestMatchers("/api/**").authenticated()

            .anyRequest().permitAll()
        )
        .addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class);

    return http.build();
}

