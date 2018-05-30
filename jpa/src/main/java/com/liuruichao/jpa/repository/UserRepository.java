package com.liuruichao.jpa.repository;

import com.liuruichao.jpa.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

/**
 * User
 *
 * @author liuruichao
 * Created on 2018/5/30 14:59
 */
public interface UserRepository extends JpaRepository<User, Integer>, JpaSpecificationExecutor<User> {
    List<User> findByName(String name);

    List<User> findByAge(Integer age);
}
