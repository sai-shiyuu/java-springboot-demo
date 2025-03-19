package com.hana.demo.config;

import org.apache.logging.log4j.util.Strings;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import com.hana.demo.service.RedisService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class LoginInterceptor implements HandlerInterceptor {

    private static final Logger logger = LoggerFactory.getLogger(LoginInterceptor.class);

    @Autowired
    private RedisService redisService;

    @Override
    public boolean preHandle(@NonNull HttpServletRequest request,@NonNull HttpServletResponse response,@NonNull Object handler) throws Exception {

        String auth = request.getHeader("Authorization");
        if (Strings.isBlank(auth)) {
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            response.getWriter().write("Unauthorized");
            return false;
        }
        String[] auths = auth.split(" ");
        if (auths.length != 2) {
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            response.getWriter().write("Unauthorized");
            return false;
        }
        logger.info("id:{}, Token: {}", auths[0], auths[1]);

        if (auths[1] == null || inValidToken(auths[0], auths[1])) {
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            response.getWriter().write("Unauthorized");
            return false;
        }
        return true;
    }

    private boolean inValidToken(String id, String token) {
        var key = String.format("login:token:%s", id);
        logger.info("key: {}", key);
        return !token.equals(redisService.get(key));
    }
}
