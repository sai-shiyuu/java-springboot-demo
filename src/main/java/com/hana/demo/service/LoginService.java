package com.hana.demo.service;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.UUID;

import org.apache.logging.log4j.util.Strings;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hana.demo.models.entity.User;
import com.hana.demo.utils.SHA256;

@Service
public class LoginService {

    private static final Logger logger = LoggerFactory.getLogger(UserService.class);

    @Autowired
    private UserService userService;

    @Autowired
    private RedisService redisService;

    public String login(Long id, String password) {
        try {
            password = SHA256.getSHA256(password);
        } catch (UnsupportedEncodingException | NoSuchAlgorithmException e) {
            logger.error("getSHA256 error", e.getMessage());
            return "";
        }
        var user = userService.getUserById(id);
        if (user == null || !user.getPassword().equals(password)) {
            return "";
        }
        var token = UUID.randomUUID().toString();
        var key = String.format("login:token:%d", id);
        redisService.del(key);
        redisService.set(key, token);
        return token;
    }

    public boolean checkLogin(Long id, String token) {
        if (Strings.isBlank(token)) {
            return false;
        }
        var key = String.format("login:token:%d", id);
        var value = redisService.get(key);
        return token.equals(value);
    }

    public Integer register(String name, String password) throws Exception {
        var user = new User();
        user.setName(name);
        user.setPassword(password);
        return userService.insertUser(user);
    }
}
