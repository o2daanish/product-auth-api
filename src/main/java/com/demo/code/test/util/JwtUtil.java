//package com.demo.code.test.util;
//
//import com.demo.code.test.constant.Constant;
//import io.jsonwebtoken.Jwts;
//import io.jsonwebtoken.SignatureAlgorithm;
//import io.jsonwebtoken.security.Keys;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.security.core.Authentication;
//import org.springframework.stereotype.Component;
//
//import javax.crypto.SecretKey;
//import java.security.Key;
//import java.time.Instant;
//import java.time.temporal.ChronoUnit;
//import java.util.ArrayList;
//import java.util.Date;
//import java.util.List;
//import java.util.Map;
//import java.util.stream.Collectors;
//
//import static com.demo.code.test.constant.Constant.BEARER;
//import static com.demo.code.test.constant.Constant.EXPIRATION_TIME;
//import static com.demo.code.test.constant.Constant.ROLES;
//import static com.demo.code.test.constant.Constant.SECRET_KEY;
//
//@Component
//public class JwtUtil {
//    // Generate JWT Token
////    public String generateToken(String username) {
////        return Jwts.builder()
////                .setSubject(username)
////                .setIssuedAt(new Date())
////                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 10)) // 10 hours
////                .signWith(SECRET_KEY) // Use SecretKey with recommended signWith(Key)
////                .compact();
////    }
//
//
//    public String generateToken(String username, List<String> roles) {
//        return Jwts.builder()
//                .claim("sub", username)
//                .setClaims(Map.of(ROLES, roles)) // Add roles to the JWT payload
//                .setSubject(username)
//                .setIssuedAt(new Date())
//                .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
//                .signWith(SECRET_KEY)
//                .compact();
//    }
//
////    public String generateJwtToken(Authentication authentication)  {
////        Instant expirationTime = Instant.now().plus(1, ChronoUnit.HOURS);
////        Date expirationDate = Date.from(expirationTime);
////        UserPrinciple userPrincipal = (UserPrinciple) authentication.getPrincipal();
////        Key key = Keys.hmacShaKeyFor(jwtSecret.getBytes());
////
////        String compactTokenString = Jwts.builder()
////                .claim("sub", userPrincipal.getUsername())
////                .setExpiration(expirationDate)
////                .signWith(key, SignatureAlgorithm.HS256)
////                .compact();
////
////        return "Bearer " + compactTokenString;
////    }
//
//    // Extract Username from Token
//    public String extractUsername(String token) {
//        return Jwts.parserBuilder()
//                .setSigningKey(SECRET_KEY)
//                .build()
//                .parseClaimsJws(token)
//                .getBody()
//                .getSubject();
//    }
//
//    public List<String> extractRoles(String token) {
//        Object roles = Jwts.parserBuilder()
//                .setSigningKey(SECRET_KEY)
//                .build()
//                .parseClaimsJws(token)
//                .getBody()
//                .get(ROLES);
//
//        if (roles instanceof List<?>) { // Check if roles is a List
//            return ((List<?>) roles).stream()
//                    .filter(role -> role instanceof String) // Ensure each element is a String
//                    .map(Object::toString)
//                    .collect(Collectors.toList());
//        }
//        return new ArrayList<>(); // Return an empty list if roles is not found
//    }
//
//
//    // Validate Token
//    public boolean validateToken(String token) {
//        try {
//            Jwts.parserBuilder()
//                    .setSigningKey(SECRET_KEY)
//                    .build()
//                    .parseClaimsJws(token);
//            return true;
//        } catch (Exception e) {
//            return false;
//        }
//    }
//}
