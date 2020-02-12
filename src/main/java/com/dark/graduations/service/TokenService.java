package com.dark.graduations.service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.dark.graduations.pojo.Admin;
import com.dark.graduations.pojo.Student;
import com.dark.graduations.pojo.Teacher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.concurrent.TimeUnit;

@Service("TokenService")
public class TokenService {

    private RedisTemplate redisTemplate;

    @Autowired
    public void setRedisTemplate(RedisTemplate redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    //学生端获取token
    public String getToken(String username, String password) {
        LocalDateTime start = LocalDateTime.now();
        //一小时有效时间
        LocalDateTime end = start.plusHours(1);
        String token = JWT.create().withAudience(username).withIssuedAt(Date.from(start.atZone(ZoneId.systemDefault()).toInstant())).withExpiresAt(Date.from(end.atZone(ZoneId.systemDefault()).toInstant()))
                .sign(Algorithm.HMAC256(password));

        redisTemplate.opsForHash().put("token", username, token);

        return token;
    }
}
