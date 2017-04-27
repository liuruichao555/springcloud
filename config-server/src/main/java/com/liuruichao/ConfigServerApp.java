package com.liuruichao;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.cloud.config.server.EnableConfigServer;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.ConfigurableEnvironment;

/**
 * ConfigServer
 *
 * @author liuruichao
 * Created on 2017/2/8 14:59
 */
@Configuration
@EnableAutoConfiguration
@EnableConfigServer
public class ConfigServerApp {
    public static void main(String[] args) {
        SpringApplication.run(ConfigServerApp.class, args);
        //ConfigurableEnvironment environment = .getEnvironment();
    }
}