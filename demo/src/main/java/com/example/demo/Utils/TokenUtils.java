package com.example.demo.utils;

import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;

public class TokenUtils {
    

    private final static String ACCESS_TOKEN_SECRET = "343432423432342";
    private final static Long ACCESS_TOKEN_EXPIRATION = 1000 * 60 * 60 * 24L; // 1 day


    public static String CreateToken(String nombre, String email){
        long expirationTime = ACCESS_TOKEN_EXPIRATION * 1_000;
        Date expiratioDate = new Date(System.currentTimeMillis() + expirationTime);
        
        Map<String, Object> extra = new HashMap<>();
        extra.put("nombre", nombre);

        return Jwts.builder()
            .setSubject(email)
            .setExpiration(expiratioDate)
            .addClaims(extra)
            .signWith(Keys.hmacShaKeyFor(ACCESS_TOKEN_SECRET.getBytes()))
            .compact();
        } 

        public static UsernamePasswordAuthenticationToken getAuthentication(String token) {
          try{
            Claims claims = Jwts.parserBuilder()
                .setSigningKey(Keys.hmacShaKeyFor(ACCESS_TOKEN_SECRET.getBytes()))
                .build()
                .parseClaimsJws(token)
                .getBody();

                String email = claims.getSubject();

                return new UsernamePasswordAuthenticationToken(email,null, Collections.emptyList());
          }
            catch(Exception e){
                return null;
            }
        }

    }

            // setSubject(email).
            // setExpiration(expiratioDate).
            // addClaims(extra).
            // signWith(Keys.hmacShaKeyFor(ACCESS_TOKEN_SECRET.getBytes()))
            // .compact();