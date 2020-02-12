package com.dark.graduations.util.WebConfigurer;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTDecodeException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.dark.graduations.mapper.AdminMapper;
import com.dark.graduations.mapper.StudentMapper;
import com.dark.graduations.pojo.Student;
import com.dark.graduations.pojo.Teacher;
import com.dark.graduations.util.token.PassToken;
import com.dark.graduations.util.token.UserLoginToken;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;


@Slf4j
public class AuthenticationInterceptor implements HandlerInterceptor {
    private String Authorization = "Authorization";

    private RedisTemplate redisTemplate;

    @Autowired
    public void setRedisTemplate(RedisTemplate redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object object) throws Exception {
        //从http请求头部获取token
        String token = httpServletRequest.getHeader(Authorization);
        //如果不是映射到方法直接通过
        if (!(object instanceof HandlerMethod)) {
            return true;
        }
        HandlerMethod handlerMethod = (HandlerMethod) object;
        Method method = handlerMethod.getMethod();
        //检查是否有passtoken注释，有则跳过认证
        if (method.isAnnotationPresent(PassToken.class)) {
            PassToken passToken = method.getAnnotation(PassToken.class);
            if (passToken.required()) {
                return true;
            }
        }

        //检查有没有需要用户权限的注解
        if (method.isAnnotationPresent(UserLoginToken.class)) {
            UserLoginToken userLoginToken = method.getAnnotation(UserLoginToken.class);
            if (userLoginToken.required()) {
                // 执行认证
                if (token == null) {
                    throw new RuntimeException("无token，请重新登录");
                }
                // 获取 token 中的 user id
                String username;
                String password;
                try {
                    username = JWT.decode(token).getAudience().get(0);
                    password = JWT.decode(token).getAudience().get(3);
                } catch (JWTDecodeException j) {
                    throw new RuntimeException("401");
                }

                //缓存中　username --　对应的token
                String cache = redisTemplate.opsForHash().get("token", username).toString();
                if (cache == null) {
                    throw new RuntimeException("用户不存在，请重新登录");
                } else if (!cache.equals(token)) {
                    throw new RuntimeException("token错误，请重新登陆");
                }


                // 验证 token
                JWTVerifier jwtVerifier = JWT.require(Algorithm.HMAC256(password)).build();

                try {
                    jwtVerifier.verify(token);
                } catch (JWTVerificationException e) {
                    throw new RuntimeException("401, token令牌无效");
                }
                return true;
            }
        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }
    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}
