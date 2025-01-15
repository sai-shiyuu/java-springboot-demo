package com.hana.demo.service;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hana.demo.mappers.UserMapper;
import com.hana.demo.models.entity.User;
import com.hana.demo.utils.SHA256;

@Service
public class UserService {

    private static final Logger logger = LoggerFactory.getLogger(UserService.class);

    @Autowired
    private UserMapper userMapper;

    public User getUserById(Long id) {
        logger.info("getUserById {}", id);
        return userMapper.getUserById(id);
    }

    public ArrayList<User> getUsersByName(String name) {
        logger.info("getUsersByName {}", name);
        return userMapper.getUsersByName(name);
    }

    public Integer insertUser(User user) throws Exception {
        try {
            user.setPassword(SHA256.getSHA256(user.getPassword()));
        } catch (UnsupportedEncodingException | NoSuchAlgorithmException e) {
            logger.error("getSHA256 error", e.getMessage());
            throw new Exception("register error.");
        }
        logger.info("insertUser {}", user);
        return userMapper.insertUser(user);
    }

    public Integer updateUser(User user) {
        logger.info("updateUser {}", user);
        return userMapper.updateUser(user);
    }

    public Integer deleteUser(Long id) {
        logger.info("deleteUser {}", id);
        return userMapper.deleteUser(id);
    }
}
