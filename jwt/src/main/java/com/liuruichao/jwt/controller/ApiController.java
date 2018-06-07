package com.liuruichao.jwt.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * ApiController
 *
 * @author liuruichao
 * Created on 2018/6/7 17:18
 */
@RestController
public class ApiController {
    // @PreAuthorize("#oauth2.hasScope('bar') and #oauth2.hasScope('read')")
    @GetMapping("/api/hello")
    public ResponseEntity<String> hello() {
        return ResponseEntity.ok("hello");
    }

    @GetMapping("/api/hello2")
    public ResponseEntity<String> hello2() {
        return ResponseEntity.ok("hello2");
    }
}
