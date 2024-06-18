package com.thuctapproject.jwt;

import com.thuctapproject.service.CustomUserDetails;
import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.util.Date;

@Component
@Slf4j
public class JwtTokenProvider {
    @Value("${com.thuctapproject.jwt.secret}")
    private  String JWT_SECRET;
    @Value("${com.thuctapproject.jwt.expiration}")
    private int JWT_EXPIRATION;

//tao jwt tu thong tin user
    SecretKey key = Keys.secretKeyFor(SignatureAlgorithm.HS256);
    public String generateToken(CustomUserDetails customUserDetails){
        Date now = new Date();
        Date dateExpired = new Date(now.getTime()+JWT_EXPIRATION);
        return Jwts.builder().setSubject(customUserDetails.getUsername())
                .setIssuedAt(now)
                .setExpiration(dateExpired)
                .signWith(key)
                .compact();
    }
    //lay thong tin user tu jwt
    public String getUserNameFromJwt (String token){
        Claims claims = Jwts.parserBuilder()
                .setSigningKey(key)
                .build()// Xây dựng JwtParser
                .parseClaimsJws(token)
                .getBody();
        return claims.getSubject();

    }
    //validate thong tin cua jwt
    public  boolean validateToken(String token){
        try{
            Jwts.parserBuilder()
                       .setSigningKey(key)
                    .build()
                    .parseClaimsJws(token);
            return true;
        }catch (MalformedJwtException ex){
            log.error("Invalid JWT token");
        }catch (ExpiredJwtException ex){
            log.error("Expired JWT token");
        }catch(UnsupportedJwtException ex){
            log.error("Unsupported JWT ex");
        }catch (IllegalArgumentException ex){
            log.error("IllegaArgument JWT ex");
        }
        return false;
    }
}
