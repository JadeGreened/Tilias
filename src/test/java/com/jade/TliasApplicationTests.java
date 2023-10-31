package com.jade;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.crypto.SecretKey;
import javax.xml.crypto.Data;
import java.util.*;

//@SpringBootTest
class TliasApplicationTests {


        // Generate a SecretKey for SignatureAlgorithm.HS256
        private SecretKey key = Keys.secretKeyFor(SignatureAlgorithm.HS256);

        @Test
        void testGenJwt() {
            Map<String, Object> claims = new HashMap<>();
            claims.put("id", "1");
            claims.put("name", "tom");

            String jwt = Jwts.builder()
                    .signWith(key) // Use the SecretKey instance here
                    .setClaims(claims)
                    .setExpiration(new Date(System.currentTimeMillis() + 3600 * 1000))
                    .compact();

            System.out.println(jwt);

            Claims claims1 = Jwts.parserBuilder()
                    .setSigningKey(key) // Use the SecretKey instance here
                    .build()
                    .parseClaimsJws(jwt)
                    .getBody();
            System.out.println(claims1);
        }
    }


