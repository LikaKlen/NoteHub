package com.note.NoteHub.security;


import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class JwtCore {
//    @Value("${NoteHub.app.secret}")
//    private String secret;
//    @Value("${NoteHub.app.lifetime}")
//    private int lifetime;
//
//    public String generateToken(UserDetails userDetails) {
//        return Jwts.builder().setSubject(userDetails.getUsername()).setIssuedAt(new Date()).setExpiration(new Date((new Date().getTime() + lifetime)))
//                .signWith(SignatureAlgorithm.HS256, secret).compact();
//    }
//
//    public String getNameFromJwt(String token) {
//        return Jwts.parser().setSigningKey(secret).build().parseClaimsJws(token).getBody().getSubject();
//    }
}