// package com.example.demo.config;

// public class JwtUtil {
//     public static String generateToken(String email) {
//         return "jwt-token-" + email;
//     }
    
//     public static boolean validateToken(String token) {
//         return token != null && token.startsWith("jwt-token-");
//     }
// }


package com.example.demo.config;

import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Component;
import java.security.Key;
import java.util.Date;

@Component
public class JwtUtil {
    private final String SECRET = "mySecretKeymySecretKeymySecretKeymySecretKey";
    private final Key key = Keys.hmacShaKeyFor(SECRET.getBytes());
    private final int EXPIRATION = 86400000; // 24 hours

    public String generateToken(String email) {
        return Jwts.builder()
                .setSubject(email)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION))
                .signWith(key)
                .compact();
    }

    public boolean validateToken(String token) {
        try {
            Jwts.parserBuilder().setSigningKey(key).build().parseClaimsJws(token);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public String getEmailFromToken(String token) {
        return Jwts.parserBuilder().setSigningKey(key).build()
                .parseClaimsJws(token).getBody().getSubject();
    }
}