package com.hana.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hana.demo.models.dto.LoginDTO;
import com.hana.demo.models.dto.RegisterDTO;
import com.hana.demo.service.LoginService;

@RestController
public class LoginController {

    @Autowired
    private LoginService loginService;

    @PostMapping("/login")
    public String login(@RequestBody LoginDTO dto) {
        return loginService.login(dto.getId(), dto.getPassword());
    }

    @PostMapping("/register")
    public Integer register(@RequestBody RegisterDTO dto) throws Exception {
        return loginService.register(dto.getName(), dto.getPassword());
    }

    // just for test
    @GetMapping("/getSHA256")
    public String getSHA256(@RequestParam("password") String password) throws Exception {
        return com.hana.demo.utils.SHA256.getSHA256(password);
    }

}
