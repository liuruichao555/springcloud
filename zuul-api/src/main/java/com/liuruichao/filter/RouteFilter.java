package com.liuruichao.filter;

import com.netflix.zuul.ZuulFilter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * RouteFilter
 *
 * @author liuruichao
 * Created on 2018/5/30 11:05
 */
public class RouteFilter extends ZuulFilter {
    private Logger log = LoggerFactory.getLogger(AccessFilter.class);

    @Override
    public String filterType() {
        log.info("RouteFilter proccess..");
        return "route";
    }

    @Override
    public int filterOrder() {
        return 0;
    }

    @Override
    public boolean shouldFilter() {
        return false;
    }

    @Override
    public Object run() {
        return null;
    }
}
