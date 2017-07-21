package com.liuruichao.service;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * UserService
 *
 * @author liuruichao
 * Created on 2017/7/21 15:43
 */
@FeignClient(name = "TEST-SERVICE")
public interface UserService {
    @GetMapping("/")
    String hello();

    @GetMapping("/add")
    Integer add(@RequestParam(name = "a") int a, @RequestParam(name = "b") int b);
}
