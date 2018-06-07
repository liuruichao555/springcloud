package com.liuruichao.jwt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * JwtApplication
 *
 * @author liuruichao
 * Created on 2018/6/7 10:59
 */
@SpringBootApplication
public class JwtApplication {
    public static void main(String[] args) {
        SpringApplication.run(JwtApplication.class, args);
    }

    @Bean
    public BCryptPasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
}
