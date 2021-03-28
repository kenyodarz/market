package com.bykenyodarz.market.web.security.utils;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Date;

public class JwtUtils {

    private static final String KEY = "LEn2WplxIT97H63YodVDJUGRuzfMqNvA";


    public String generateJwt(UserDetails userDetails){
        return Jwts
                .builder()
                .setSubject(userDetails.getUsername())
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + 1000*60*60*10))
                .signWith(SignatureAlgorithm.HS256, KEY)
                .compact();
    }
}
