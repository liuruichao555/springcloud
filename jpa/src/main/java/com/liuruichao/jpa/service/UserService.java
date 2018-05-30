package com.liuruichao.jpa.service;

import com.liuruichao.jpa.model.User;
import com.liuruichao.jpa.repository.UserRepository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.transaction.Transactional;
import java.util.List;

/**
 * UserService
 *
 * @author liuruichao
 * Created on 2018/5/30 14:58
 */
@Service
@Transactional(rollbackOn = Exception.class)
public class UserService {
    @Resource
    private UserRepository userRepository;

    public Integer addUser(User user) {
        user = userRepository.save(user);
        return user.getId();
    }

    public List<User> getUserByName(String name) {
        return userRepository.findByName(name);
    }

    public List<User> getUserByAge(Integer age) {
        return userRepository.findByAge(age);
    }
}
