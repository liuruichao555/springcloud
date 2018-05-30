package com.liuruichao.jpa.controller;

import com.liuruichao.jpa.model.User;
import com.liuruichao.jpa.service.UserService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * UserController
 *
 * @author liuruichao
 * Created on 2018/5/30 15:12
 */
@RestController
@RequestMapping("/user")
public class UserController {
    @Resource
    private UserService userService;

    @PostMapping
    public Integer add(User user) {
        return userService.addUser(user);
    }
}
