package com.liuruichao.jwt.service;

import com.liuruichao.jwt.model.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * UserService
 *
 * @author liuruichao
 * Created on 2018/6/7 14:47
 */
@Service
@Slf4j
public class UserService implements UserDetailsService {
    @Resource
    private PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        log.info("username: {}.", username);
        // TODO test
        if (username.equals("liuruichao")) {
            String password = "liuruichao123";
            User user = new User();
            user.setUsername("liuruichao");
            // 密码必须加密
            user.setPassword(passwordEncoder.encode("liuruichao123"));
            user.setRoles(buildTestRoles());
            return user;
        }
        throw new UsernameNotFoundException("username: " + username);
    }

    private List<String> buildTestRoles() {
        List<String> roles = new ArrayList<>();
        roles.add("ADMIN");
        roles.add("USER");

        return roles;
    }
}
