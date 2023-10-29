package com.PracticaSpring.jwt;

import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import com.PracticaSpring.Models.Person.Person;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;

@Service
public class JwtServise {
    private static final String SECRET_KEY = "586E3272357538782F413F4428472B4B6250655368566B597033733676397924";

    public String getToken(UserDetails person) {
        return getToken(new HashMap<>(), person);
    }

    private String getToken(Map<String, Object> extraClaims, UserDetails person) {
        return Jwts
                .builder()
                .setClaims(extraClaims) // ajusta el extraClaims
                .setSubject(person.getUsername())// setea el username
                .setIssuedAt(new Date(System.currentTimeMillis()))// setea la fecha de creacion
                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 24)) // setea la fecha de vencimiento
                .signWith(getKey(), SignatureAlgorithm.HS256) // setea el ripo de cifrado
                .compact(); // crea el jwts
    }

    private Key getKey() {
        byte[] keyBytes = Decoders.BASE64.decode(SECRET_KEY);
        return Keys.hmacShaKeyFor(keyBytes);
    }

}
