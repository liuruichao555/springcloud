package com.liuruichao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
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
@RestController
public class EurekaConsumerApplication {
    @Bean
    @LoadBalanced
    RestTemplate restTemplate() {
        return new RestTemplate();
    }

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

    public static void main(String[] args) throws InterruptedException {
        SpringApplication.run(EurekaConsumerApplication.class, args);
    }
}
