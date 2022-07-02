package com.cs545waa.lab06.security;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.Map;

@Component
public class JWTHelper {
    private final String secret="XHuQDP8m8jZPaEX9w86Vx5fYZMFL" +
            "TusUddhpKsEcCARdhBZrhdB2VJ9bvjDdsnJUZfHfjnAy9tWKu" +
            "mepMxJmt7Mxf9UsJp8fr2kx3UuB9U2gStA3aBfUBbdgSXMNBd" +
            "xTGxPuBeqz78XrEWpQLnDmANDz2fubQV4CTdHZra68fbLe82e" +
            "fBrHdNxUyNFNLhhkPwkyFzKeZ8xnjcKPzMqhcHnkpdFjQFxqm" +
            "9Av4bepR6Wf52drMk2mUsj4gdF2sCdvV";
    private final long expiration=5*60*60*60;
    public String generateToken(String email){

        return Jwts.builder()
                .setSubject(email)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis()+expiration))
                .signWith(SignatureAlgorithm.HS256,secret)
                .compact();
    }
    public String getSubject(String token){
        return Jwts.parser()
                .setSigningKey(secret)
                .parseClaimsJws(token)
                .getBody()
                .getSubject();
    }
    public boolean validateToken(String token){
        try{
            Jwts.parser()
                    .setSigningKey(secret)
                    .parseClaimsJws(secret);
            return true;
        }
        catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }
    public String getUsername(String token){
        String username= Jwts.parser()
                .setSigningKey(secret)
                .parseClaimsJws(token)
                .getBody()
                .getSubject();
        return username;
    }

    public String doGenerateRefreshToken(Map<String, Object> claims, String subject) {

        return Jwts.builder().setClaims(claims).setSubject(subject).setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + expiration))
                .signWith(SignatureAlgorithm.HS512, secret).compact();
    }

    public String generateRefreshToken(String email) {
        return Jwts.builder()
                .setSubject(email)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + expiration * 60))
                .signWith(SignatureAlgorithm.HS512, secret)
                .compact();
    }
}
