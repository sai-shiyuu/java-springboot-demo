package com.hana.demo;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.hana.demo.service.RedisService;

@SpringBootTest
class DemoApplicationTests {

    @Autowired
    private RedisService redisService;

    @Test
    void contextLoads() {
    }

    @Test
    void testRedisService() {
        redisService.set("a", "1");
        assert "1".equals(redisService.get("a"));
        redisService.del("a");
        assert redisService.get("a") == null;
        redisService.setNx("a", "1", 10, java.util.concurrent.TimeUnit.SECONDS);
        assert redisService.setNx("a", "1", 10, java.util.concurrent.TimeUnit.SECONDS) == false;
    }

    @Test
    void testSHA256() {
        try {
            assert "a03c32fcd351cba2d9738622b083bed022ef07793bd92b59faea0207653f371d"
                    .equals(com.hana.demo.utils.SHA256.getSHA256("abc123456"));
        } catch (UnsupportedEncodingException | NoSuchAlgorithmException e) {
            System.err.println("testSHA256 error");
        }
    }
}
