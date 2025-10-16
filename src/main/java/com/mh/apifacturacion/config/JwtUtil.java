package com.mh.apifacturacion.config;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Date;
import javax.crypto.SecretKey;

@Component
public class JwtUtil {
    @Value("${app.jwt.secret}")
    private String secret;

    @Value("${app.jwt.expirationSeconds}")
    private long expirationSeconds;
    
    private static final SecretKey SECRET_KEY = Keys.secretKeyFor(SignatureAlgorithm.HS512);

    public String generateToken(String subject, String role) {
        Date now = new Date();
        Date exp = new Date(now.getTime() + expirationSeconds * 1000);
        return Jwts.builder()
                .setSubject(subject)
                .claim("role", role)
                .setIssuedAt(now)
                .setExpiration(exp)
                .signWith(SECRET_KEY, SignatureAlgorithm.HS512)
                .compact();
    }
}
