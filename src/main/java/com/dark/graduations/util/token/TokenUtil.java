package com.dark.graduations.util.token;

import com.auth0.jwt.JWT;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * 从token中获取用户id
 */
public class TokenUtil {
    public static String getTokenUserId() {
        String token = getRequest().getHeader("Authorization");// 从 http 请求头中取出 token
        String StuId = JWT.decode(token).getAudience().get(0);
        return StuId;
    }
    /**
     * 获取request
     *
     * @return
     */
    public static HttpServletRequest getRequest() {
        ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder
                .getRequestAttributes();
        return requestAttributes == null ? null : requestAttributes.getRequest();
    }
}
