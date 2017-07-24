package com.liuruichao;

import com.liuruichao.service.HystrixService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * HystrixApplication
 *
 * @author liuruichao
 * Created on 2017/7/24 15:29
 */
@EnableCircuitBreaker
@EnableHystrixDashboard
@SpringBootApplication
@RestController
public class HystrixApplication {
    @Resource
    private HystrixService hystrixService;

    @GetMapping("/")
    public String hello() {
        return hystrixService.callDependencyService();
    }

    public static void main(String[] args) {
        SpringApplication.run(HystrixApplication.class, args);
    }
}
