package com.liuruichao;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;

/**
 * TestApplication
 *
 * @author liuruichao
 * Created on 2017/7/29 21:11
 */
@SpringBootApplication
@RestController
public class TestApplication {
    @GetMapping("/test1")
    public String hello(@RequestParam String name, @RequestParam String[] args) {
        System.out.println(String.format("name: %s, args: %s.", name, Arrays.toString(args)));
        return "test1";
    }

    @GetMapping("/test2")
    public String hello2(@ModelAttribute User user) {
        System.out.println("user: " + user);
        return "test2";
    }

    @PostMapping("/test3")
    public String hello3(@RequestBody User user) {
        System.out.println("user: " + user);
        return "test3";
    }

    public static void main(String[] args) {
        SpringApplication.run(TestApplication.class, args);
    }
}
