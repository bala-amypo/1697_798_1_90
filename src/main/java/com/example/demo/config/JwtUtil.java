// // package com.example.demo.config;

// // public class JwtUtil {
// //     public static String generateToken(String email) {
// //         return "jwt-token-" + email;
// //     }
    
// //     public static boolean validateToken(String token) {
// //         return token != null && token.startsWith("jwt-token-");
// //     }
// // }



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



// // package com.example.demo.config;

// // import io.jsonwebtoken.*;
// // import io.jsonwebtoken.security.Keys;
// // import org.springframework.beans.factory.annotation.Value;
// // import org.springframework.stereotype.Component;
// // import java.security.Key;
// // import java.util.Date;

// // @Component
// // public class JwtUtil {
// //     @Value("${jwt.secret}")
// //     private String SECRET;
    
// //     @Value("${jwt.expiration}")
// //     private int EXPIRATION;
    
// //     private Key getSigningKey() {
// //         return Keys.hmacShaKeyFor(SECRET.getBytes());
// //     }

// //     public String generateToken(String email) {
// //         return Jwts.builder()
// //                 .setSubject(email)
// //                 .setIssuedAt(new Date())
// //                 .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION))
// //                 .signWith(getSigningKey())
// //                 .compact();
// //     }

// //     public boolean validateToken(String token) {
// //         try {
// //             Jwts.parserBuilder().setSigningKey(getSigningKey()).build().parseClaimsJws(token);
// //             return true;
// //         } catch (Exception e) {
// //             return false;
// //         }
// //     }

// //     public String getEmailFromToken(String token) {
// //         return Jwts.parserBuilder().setSigningKey(getSigningKey()).build()
// //                 .parseClaimsJws(token).getBody().getSubject();
// //     }
// // }



package com.example.demo.config;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class JwtUtil {

    private static final String SECRET_KEY = "mysecretkey123456";
    private static final long EXPIRATION_TIME = 1000 * 60 * 60; // 1 hour

    public String generateToken(String username) {
        return Jwts.builder()
                .setSubject(username)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
                .signWith(SignatureAlgorithm.HS256, SECRET_KEY)
                .compact();
    }

    public String extractUsername(String token) {
        return getClaims(token).getSubject();
    }

    public boolean validateToken(String token, String username) {
        return extractUsername(token).equals(username) && !isTokenExpired(token);
    }

    private boolean isTokenExpired(String token) {
        return getClaims(token).getExpiration().before(new Date());
    }

    private Claims getClaims(String token) {
        return Jwts.parser()
                .setSigningKey(SECRET_KEY)
                .parseClaimsJws(token)
                .getBody();
    }
}
