package com.liuruichao.jpa.repository;

import com.liuruichao.jpa.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * User
 *
 * @author liuruichao
 * Created on 2018/5/30 14:59
 */
public interface UserRepository extends JpaRepository<User, Integer> {
    List<User> findByName(String name);

    List<User> findByAge(Integer age);
}
