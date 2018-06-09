package com.liuruichao.ldap.service;

import com.liuruichao.ldap.model.Person;
import com.liuruichao.ldap.repository.PersonRepository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * PersonService
 *
 * @author liuruichao
 * Created on 2018/6/8 22:50
 */
@Service
public class PersonService {
    @Resource
    private PersonRepository personRepository;

    public Person addPerson(Person person) {
        person = personRepository.save(person);
        return person;
    }
}
