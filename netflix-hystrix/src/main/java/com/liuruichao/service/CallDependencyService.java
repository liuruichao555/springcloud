package com.liuruichao.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.stereotype.Service;

import java.util.Random;

/**
 * CallDependencyService
 *
 * @author liuruichao
 * Created on 2017/7/24 15:34
 */
@Service
public class CallDependencyService {
    private Random random = new Random();

    @HystrixCommand(fallbackMethod = "fallback")
    public String mockGetUserInfo() {
        int randomInt = random.nextInt(10);
        if (randomInt < 8) {  //模拟调用失败情况
            throw new RuntimeException("call dependency service fail.");
        } else {
            return "username: liuruichao, number: " + randomInt;
        }
    }

    public String fallback() {
        // 默认返回值
        return "default hello";
    }
}
