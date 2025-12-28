package com.example.demo.config;

public class JwtUtil {
    public static String generateToken(String email) {
        return "jwt-token-" + email;
    }
    
    public static boolean validateToken(String token) {
        return token != null && token.startsWith("jwt-token-");
    }
}


