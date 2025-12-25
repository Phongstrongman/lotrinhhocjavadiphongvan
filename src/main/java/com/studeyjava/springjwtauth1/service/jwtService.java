package com.studeyjava.springjwtauth1.service;
import javax.crypto.SecretKey;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import io.jsonwebtoken.SignatureAlgorithm;
import java.util.Date;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;



@Service
public class jwtService {

    private final SecretKey ACCESS_SECRET_KEY = 
    Keys.hmacShaKeyFor("S3cretkeyForAccessToken_S3cretkeyForAccessToken".getBytes());
    private final SecretKey REFRESH_SECRET_KEY =
    Keys.hmacShaKeyFor("S3cr3tKeyForRefreshToken_S3cr3tKeyForRefreshToken".getBytes());
    
    //Tạo Access Token (đúng tên hàm Controller cần)
    public String generrateAccessToken(UserDetails  user){

        return Jwts.builder()
        .setSubject(user.getUsername())
        .claim("roles", user.getAuthorities())
        .setIssuedAt(new Date())
        .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 15)) //15 phút
        .signWith(ACCESS_SECRET_KEY, SignatureAlgorithm.HS256)
        .compact();

    }
//Tạo Refresh Token (đúng tên hàm Controller cần)
    public String generrateRefreshToken(UserDetails  user){

        return Jwts.builder()
        .setSubject(user.getUsername())
        .setIssuedAt(new Date())
        .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 24 *7)) //7 ngày
        .signWith(REFRESH_SECRET_KEY, SignatureAlgorithm.HS256)
        .compact();

    }
//lấy user từ token 
public String extractUsername(String token, boolean isAccessToken){
   return Jwts.parserBuilder()
   .setSigningKey(isAccessToken ? ACCESS_SECRET_KEY : REFRESH_SECRET_KEY)
   .build()
   .parseClaimsJws(token)
    .getBody()
    .getSubject();
}
}