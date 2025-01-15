package com.hana.demo.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hana.demo.models.entity.User;
import com.hana.demo.models.vo.UserVO;
import com.hana.demo.service.UserService;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/user")
    public UserVO getUser(@RequestParam("id") Long id) {
        var user = userService.getUserById(id);
        var vo = new UserVO();
        vo.setId(user.getId());
        vo.setName(user.getName());
        vo.setCtime(user.getCtime());
        vo.setMtime(user.getMtime());
        return vo;
    }

    @GetMapping("/getUsersByName")
    public ArrayList<User> getUsersByName(@RequestParam("name") String name) {
        return userService.getUsersByName(name);
    }

    @PutMapping("/user")
    public Integer putMethodName(@RequestBody User user) {
        return userService.updateUser(user);
    }

    @DeleteMapping("/user")
    public Integer deleteMethodName(@RequestParam("id") Long id) {
        return userService.deleteUser(id);
    }
}
