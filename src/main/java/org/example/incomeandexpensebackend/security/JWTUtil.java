package org.example.incomeandexpensebackend.security;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.util.Date;
import java.util.Map;

@Component
public class JWTUtil {
    private final Key secret = Keys.secretKeyFor(SignatureAlgorithm.HS256);
    private final long expiration = 86400000;

    public String generateToken(String email, String name, String surname) {
        return Jwts.builder()
                .setSubject(email)
                .addClaims(Map.of(
                        "firstName", name,
                        "lastName", surname
                ))
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + expiration))
                .signWith(SignatureAlgorithm.HS256, secret)
                .compact();
    }

    public String validateTokenAndGetEmail(String token) {
        return Jwts.parser()
                .setSigningKey(secret)
                .parseClaimsJws(token)
                .getBody()
                .getSubject();
    }

}
