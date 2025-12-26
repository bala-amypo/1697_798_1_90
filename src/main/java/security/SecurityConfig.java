package com.example.demo.security;

public class SecurityConfig {
    public boolean isSecurityEnabled() {
        return true;
    }
    
    public String[] getPublicEndpoints() {
        return new String[]{"/api/public/**"};
    }
}