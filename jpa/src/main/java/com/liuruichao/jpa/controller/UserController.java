package com.liuruichao.jpa.controller;

import com.liuruichao.jpa.model.User;
import com.liuruichao.jpa.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * UserController
 *
 * @author liuruichao
 * Created on 2018/5/30 15:12
 */
@RestController
@RequestMapping("/user")
@Slf4j
public class UserController {
    @Resource
    private UserService userService;

    @PostMapping
    public Integer addUser(User user) {
        return userService.addUser(user);
    }

    @GetMapping("/name/{name}")
    public List<User> getUser(@PathVariable String name) {
        if (StringUtils.isEmpty(name)) {
            return null;
        }
        return userService.getUser(name);
    }

    @GetMapping("/age/{age}")
    public List<User> getUser(@PathVariable Integer age) {
        if (age == null || age <= 0) {
            return null;
        }
        return userService.getUser(age);
    }

    @GetMapping
    public List<User> getUser(@RequestParam String name, @RequestParam Integer age) {
        return userService.getUser(name, age);
    }
}
