package com.liuruichao.jwt.resource.endpoint;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * TestController
 *
 * @author liuruichao
 * Created on 2018/6/7 18:39
 */
@RestController
public class TestController {
    @PreAuthorize("#oauth2.hasScope('read')")
    @GetMapping(value = "/test1")
    public String test1() {
        return "test1";
    }

    @PreAuthorize("#oauth2.clientHasRole('ADMIN')")
    @GetMapping(value = "/test2")
    public String test2() {
        return "test2";
    }
}