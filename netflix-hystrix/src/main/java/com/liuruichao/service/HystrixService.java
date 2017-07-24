package com.liuruichao.service;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * HystrixService
 *
 * @author liuruichao
 * Created on 2017/7/24 15:34
 */
@Service
public class HystrixService {
    @Resource
    private CallDependencyService dependencyService;

    public String callDependencyService() {
        return dependencyService.mockGetUserInfo();
    }
}
