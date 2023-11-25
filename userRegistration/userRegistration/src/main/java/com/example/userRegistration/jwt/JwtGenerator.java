package com.example.userRegistration.jwt;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.crypto.SecretKey;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.example.userRegistration.entity.AuthRequest;
import com.example.userRegistration.entity.AuthResponse;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

@Service
public class JwtGenerator {
	@Value("${jwt.secret}")
    private String secret;
    
    @Value("${app.jwttoken.message}")
    private String message;

   
//    public Map<String, String> generateToken(AuthRequest request) {
//        SecretKey key = Keys.secretKeyFor(SignatureAlgorithm.HS256);
//
//        String jwtToken = Jwts.builder()
//            .setSubject(request.getEmailid())
//            .setIssuedAt(new Date(System.currentTimeMillis()))
//            .setExpiration(new Date(System.currentTimeMillis()+ 24 * 60 * 60 * 1000))
//            .signWith(key)
//            .compact();
//        
//        Map<String, String> jwtTokenGen = new HashMap<>();
//        jwtTokenGen.put("token", jwtToken);
//        jwtTokenGen.put("message", message);
//        return jwtTokenGen;
//
//}
    
    public String generateToken(AuthRequest request) {
        SecretKey key = Keys.secretKeyFor(SignatureAlgorithm.HS256);

        String jwtToken = Jwts.builder()
            .setSubject(request.getEmailid())
            .setIssuedAt(new Date(System.currentTimeMillis()))
            .setExpiration(new Date(System.currentTimeMillis() + 24 * 60 * 60 * 1000))
            .signWith(key)
            .compact();

        return jwtToken;
    }
    
    
    
}
