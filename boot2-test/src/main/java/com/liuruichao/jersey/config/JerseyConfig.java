package com.liuruichao.jersey.config;

import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.stereotype.Component;

/**
 * JerseyConfig
 *
 * @author liuruichao
 * Created on 2018/5/30 21:47
 */
@Component
public class JerseyConfig extends ResourceConfig {
    public JerseyConfig() {
        // TODO 过滤器、拦截器、API等
        packages("com.liuruichao.jersey");
    }
}
