package com.example.restservice.controller;

import com.example.restservice.model.UserInfoResponse;
import com.example.restservice.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/users")
public class UserInfoController {

    @Autowired
    private UserInfoService userInfoService;

    @GetMapping("/userInfo/{userId}")
    public UserInfoResponse getUserInfo(@PathVariable Integer userId) {
        return userInfoService.getUserInfo(userId);
    }
}
