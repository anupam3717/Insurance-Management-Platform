package com.example.InsuranceManagementPlatform.security;

import com.example.InsuranceManagementPlatform.exceptions.StatusCodeMyException;
import com.example.InsuranceManagementPlatform.properties.AppProperties;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtParser;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.util.Date;

import static com.example.InsuranceManagementPlatform.exceptions.ErrorCodes.AUTHENTICATION_UNVALID_DATA;

@Component
public class JwtProvider {
    @Autowired
    private AppProperties appProperties;
    public String generateToken(String userName){
        Long jwtExpiration = 3600000L;
        Key key= Keys.hmacShaKeyFor(appProperties.getSecretKey().getBytes());
        Date currentDate = new Date();
        Date expiration = new Date(currentDate.getTime() + jwtExpiration);

        return Jwts.builder()
                .setSubject(userName)
                .setExpiration(expiration)
                .setIssuedAt(currentDate)
                .signWith(key)
                .compact();

    }

    private Claims parseToken(String token){
        JwtParser jwtParser = Jwts.parserBuilder()
                .setSigningKey(appProperties.getSecretKey().getBytes())
                .build();
        try {
            Claims x = jwtParser.parseClaimsJws(token)
                    .getBody();
            return x;
        }catch (Exception e){
          return null;
        }

    }

    public boolean isTokenValid(String token){
        return parseToken(token)!=null;
    }

    public String getUserNameFromToken(String token){
        Claims claims=parseToken(token);
        return claims.getSubject();
    }
}
