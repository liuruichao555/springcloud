package com.liuruichao.jpa.service;

import com.liuruichao.jpa.model.User;
import com.liuruichao.jpa.repository.UserRepository;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.domain.Specifications;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
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

    public List<User> getUser(String name) {
        return userRepository.findByName(name);
    }

    public List<User> getUser(Integer age) {
        return userRepository.findByAge(age);
    }

    public List<User> getUser(String name, Integer age) {
        Specifications<User> specifications = Specifications
                .where((Specification<User>) (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.equal(root.get("name").as(String.class), name))
                .and((root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.equal(root.get("age").as(Integer.class), age));
        //User user = userRepository.findOne(specifications);
        return userRepository.findAll(specifications);
    }

    public List<User> test() {
        Integer id = 1;
        String name = "liuruichao";
        Integer age = 20;
        Specifications<User> specifications = Specifications
                .where((Specification<User>) (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.equal(root.get("name").as(String.class), name))
                .and(
                        Specifications.where((Specification<User>) (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.equal(root.get("id").as(Integer.class), id))
                        .or((root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.equal(root.get("age").as(Integer.class), age))
                );
        return userRepository.findAll(specifications);
    }
}
