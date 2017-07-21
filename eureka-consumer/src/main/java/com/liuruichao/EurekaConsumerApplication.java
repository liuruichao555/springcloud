package com.liuruichao;

import com.liuruichao.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * EurekaConsumerApplication
 *
 * @author liuruichao
 * Created on 2017/5/3 18:03
 */
@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
@RestController
public class EurekaConsumerApplication {
    /**
     * ribbon 方式
     */
    @Bean
    @LoadBalanced
    RestTemplate restTemplate() {
        return new RestTemplate();
    }

    @Autowired
    private UserService userService;

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/")
    public String home() {
        return restTemplate.getForEntity("http://TEST-SERVICE/", String.class).getBody();
    }

    @GetMapping("/add")
    public Integer add(@RequestParam int a, @RequestParam int b){
        String url = String.format("http://TEST-SERVICE/add?a=%s&b=%s", a, b);
        return restTemplate.getForEntity(url, Integer.class).getBody();
    }

    @GetMapping("/test1")
    public String test1() {
        return userService.hello();
    }

    @GetMapping("/test2")
    public Integer test2(@RequestParam int a, @RequestParam int b) {
        return userService.add(a, b);
    }

    public static void main(String[] args) throws InterruptedException {
        SpringApplication.run(EurekaConsumerApplication.class, args);
    }
}
