package com.portfolio.backend.utils;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.util.Date;

@Component
public class JwtUtil {
    private Key secretKey = Keys.secretKeyFor(SignatureAlgorithm.HS512);

    public String generateToken(Long userId) {
        Date now = new Date();
        Date expiryDate = new Date(now.getTime() + 86400000); // 1 day
        return Jwts.builder()
                .setSubject(String.valueOf(userId))
                .setIssuedAt(now)
                .setExpiration(expiryDate)
                .signWith(SignatureAlgorithm.HS512, secretKey)
                .compact();
    }

//    public boolean validateToken(String token) {
//        try {
//            Jwts.parser().setSigningKey(secretKey).parseClaimsJws(token);
//            return true;
//        } catch (SignatureException ex) {
//            // Invalid JWT signature
//        } catch (MalformedJwtException ex) {
//            // Invalid JWT token
//        } catch (ExpiredJwtException ex) {
//            // Expired JWT token
//        } catch (UnsupportedJwtException ex) {
//            // Unsupported JWT token
//        } catch (IllegalArgumentException ex) {
//            // JWT claims string is empty
//        }
//        return false;
//    }
}
