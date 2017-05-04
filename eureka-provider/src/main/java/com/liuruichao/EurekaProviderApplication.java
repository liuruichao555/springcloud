package com.liuruichao;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * EurekaClientApplication
 *
 * @author liuruichao
 * Created on 2017/5/3 16:34
 */
@SpringBootApplication
@Configuration
@EnableAutoConfiguration
@EnableEurekaClient
@RestController
public class EurekaProviderApplication {
    @GetMapping("/")
    public String home() {
        return "Hello World";
    }

    @GetMapping("/add")
    public Integer add(@RequestParam Integer a, @RequestParam Integer b) {
        return a + b;
    }

    /*@RequestMapping("/info")
    public String info() {
        return "info";
    }

    @RequestMapping("/health")
    public String health() {
        return "health";
    }*/

    public static void main(String[] args) {
        SpringApplication.run(EurekaProviderApplication.class, args);
    }
}
