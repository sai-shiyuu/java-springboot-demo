package com.hana.demo.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import jakarta.servlet.http.HttpServletRequest;

@Aspect
@Component
public class RequestLog {

    private static final Logger logger = LoggerFactory.getLogger(RequestLog.class);

    @Before("execution(* com.hana.demo.controller..*(..))")
    public void logBeforeControllerMethods(JoinPoint joinPoint) {
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        if (attributes != null) {
            HttpServletRequest request = attributes.getRequest();
            String url = request.getRequestURL().toString();
            logger.info("Entering url: {} with arguments: {}", url, joinPoint.getArgs());
        }
    }
}
