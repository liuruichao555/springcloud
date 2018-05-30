package com.liuruichao;

import com.liuruichao.filter.AccessFilter;
import com.liuruichao.filter.ErrorFilter;
import com.liuruichao.filter.PostFilter;
import com.liuruichao.filter.RouteFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;

/**
 * zuul api网关
 *
 * @author liuruichao
 * Created on 2017/7/24 14:30
 */
@EnableZuulProxy
@SpringCloudApplication
public class ZuulApiApplication {
    public static void main(String[] args) {
        SpringApplication.run(ZuulApiApplication.class, args);
    }

    @Bean
    public AccessFilter accessFilter() {
        return new AccessFilter();
    }

    @Bean
    public RouteFilter routeFilter() {
        return new RouteFilter();
    }

    @Bean
    public PostFilter postFilter() {
        return new PostFilter();
    }

    @Bean
    public ErrorFilter errorFilter() {
        return new ErrorFilter();
    }
}
