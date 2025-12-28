// package com.example.demo.config;

// public class JwtUtil {
//     public static String generateToken(String email) {
//         return "jwt-token-" + email;
//     }
    
//     public static boolean validateToken(String token) {
//         return token != null && token.startsWith("jwt-token-");
//     }
// }



// package com.example.demo.config;

// import io.jsonwebtoken.*;
// import io.jsonwebtoken.security.Keys;
// import org.springframework.beans.factory.annotation.Value;
// import org.springframework.stereotype.Component;
// import java.security.Key;
// import java.util.Date;

// @Component
// public class JwtUtil {
//     @Value("${jwt.secret}")
//     private String SECRET;
    
//     @Value("${jwt.expiration}")
//     private int EXPIRATION;
    
//     private Key getSigningKey() {
//         return Keys.hmacShaKeyFor(SECRET.getBytes());
//     }

//     public String generateToken(String email) {
//         return Jwts.builder()
//                 .setSubject(email)
//                 .setIssuedAt(new Date())
//                 .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION))
//                 .signWith(getSigningKey())
//                 .compact();
//     }

//     public boolean validateToken(String token) {
//         try {
//             Jwts.parserBuilder().setSigningKey(getSigningKey()).build().parseClaimsJws(token);
//             return true;
//         } catch (Exception e) {
//             return false;
//         }
//     }

//     public String getEmailFromToken(String token) {
//         return Jwts.parserBuilder().setSigningKey(getSigningKey()).build()
//                 .parseClaimsJws(token).getBody().getSubject();
//     }
// }



package com.example.demo.config;

import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import java.security.Key;
import java.util.Date;

@Component
public class JwtUtil {
    @Value("${jwt.secret}")
    private String SECRET;
    
    @Value("${jwt.expiration}")
    private int EXPIRATION;
    
    private Key getSigningKey() {
        return Keys.hmacShaKeyFor(SECRET.getBytes());
    }

    public String generateToken(String email) {
        return Jwts.builder()
                .setSubject(email)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION))
                .signWith(getSigningKey())
                .compact();
    }

    public boolean validateToken(String token) {
        try {
            Jwts.parserBuilder().setSigningKey(getSigningKey()).build().parseClaimsJws(token);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public String getEmailFromToken(String token) {
        return Jwts.parserBuilder().setSigningKey(getSigningKey()).build()
                .parseClaimsJws(token).getBody().getSubject();
    }
}