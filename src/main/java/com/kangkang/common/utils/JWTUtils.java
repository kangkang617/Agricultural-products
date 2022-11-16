package com.kangkang.common.utils;

import io.jsonwebtoken.*;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * ClassName:JWTUtils
 * Package:com.kangkang.common.utils
 * Description:
 *
 * @date:2022/5/16 17:51
 * @author:kangkang
 */

//token工具类
@Component
public class JWTUtils {
    /*private String key = "kangkang"; //密钥，名称要与application.yml中配的一样
    private long expiration = 60*1000*3; //过期时间，名称要与application.yml中配的一样
    public String getKey() {
        return key;
    }
    public void setKey(String key) {
        this.key = key;
    }
    public long getExpiration() {
        return expiration;
    }
    public void setExpiration(long expiration) {
        this.expiration = expiration;
    }
    //生成token
    public String genToken(Integer uid, String username) {
        long curTime = System.currentTimeMillis();
        JwtBuilder builder = Jwts.builder()
                .setId(String.valueOf(uid)).setSubject(username) //使用用户ID与手机号
                .setIssuedAt(new Date(curTime)) //设置token创建时间
                //添加信息
                .claim("uid",uid)
                .signWith(SignatureAlgorithm.HS256, key); //进行签名，HS256方式，密钥为key
        if (expiration > 0) {
            builder.setExpiration(new Date(curTime + expiration));  //设置token过期时间
        }
        //builder.claim("key1", "value1");  //添加自定义key:value对
        return builder.compact(); //生成token
    }
    //解析token
    public Claims parser(String token) {
        Claims c = Jwts.parser().setSigningKey(key) //设置签名密钥为yyh
                .parseClaimsJws(token).getBody(); //解析token
        String uid = c.getId(); //获取token中的用户ID
        String username = c.getSubject(); //获取token中的手机号
        Date createDate = c.getIssuedAt(); //获取token的创建时间
        Date expirationDate = c.getExpiration(); //获取token的过期时间
        System.out.println(c.get("uid"));
        //String value1 = (String) c.get("key1"); //获取token中的自定义key:value
        return c;
    }*/


    private static final String jwtToken = "123456Mszlu!@#$$";

    public static String createToken(Integer uid){
        Map<String,Object> claims = new HashMap<>();
        claims.put("uid",uid);
        JwtBuilder jwtBuilder = Jwts.builder()
                .signWith(SignatureAlgorithm.HS256, jwtToken) // 签发算法，秘钥为jwtToken
                .setClaims(claims) // body数据，要唯一，自行设置
                .setIssuedAt(new Date()) // 设置签发时间
                .setExpiration(new Date(System.currentTimeMillis() + 24 * 60 * 60 * 60 * 1000));// 一天的有效时间
        String token = jwtBuilder.compact();
        return token;
    }

    public static Map<String, Object> checkToken(String token){
        try {
            Jwt parse = Jwts.parser().setSigningKey(jwtToken).parse(token);
            return (Map<String, Object>) parse.getBody();
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;

    }



}

