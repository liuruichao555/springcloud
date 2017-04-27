package com.liuruichao;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * ConfigClientApp
 *
 * @author liuruichao
 * Created on 2017/4/22 14:47
 */
@SpringBootApplication
@Configuration
@RestController
@RequestMapping("")
public class ConfigClientApp {
    @Value("${redis.host}")
    private String redisHost;

    /*@Value("${bar}")
    private String bar;*/

    @RequestMapping(method = RequestMethod.GET)
    public String hello() {
        return redisHost;
    }

    public static void main(String[] args) {
        SpringApplication.run(ConfigClientApp.class, args);
    }
}
