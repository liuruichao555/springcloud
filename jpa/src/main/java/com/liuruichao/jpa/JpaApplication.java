package com.liuruichao.jpa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * JpaApplication
 *
 * @author liuruichao
 * Created on 2018/5/30 15:11
 */
@SpringBootApplication
@Configuration
@EnableAutoConfiguration
@RestController
public class JpaApplication {
    @GetMapping
    public String home() {
        return "hello";
    }

    public static void main(String[] args) {
        SpringApplication.run(JpaApplication.class, args);
    }
}
