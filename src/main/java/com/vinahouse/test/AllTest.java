package com.vinahouse.test;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;

import java.security.Key;
import java.util.Arrays;
import java.util.Date;

public class AllTest {
    public static void main(String[] args) {
        String key = "caiwebrerachnaycoaithemvaodaylamchovuithoima";
        byte[] a = Decoders.BASE64.decode(key);
        Key s = Keys.hmacShaKeyFor(a);

//        String token = Jwts.builder().setSubject("webthuetro").setExpiration(new Date(new Date().getTime() + 120000000))
//                .signWith(s, SignatureAlgorithm.HS256).compact();
//        System.out.println(token);
        String ga = Jwts.parserBuilder().setSigningKey(s).build().parseClaimsJws("eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ3ZWJ0aHVldHJvIiwiZXhwIjoxNjk2NjcyMDc1fQ.02tG2Qqjd8j9viEARUkh21KD1v_ytSJWuKSCOQiqErA")
                .getBody().getSubject();
        System.out.println(ga);
    }
}
