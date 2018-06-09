package com.liuruichao.ldap.controller;

import com.liuruichao.ldap.model.Person;
import com.liuruichao.ldap.repository.PersonRepository;
import com.liuruichao.ldap.service.PersonService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

/**
 * PersonController
 *
 * @author liuruichao
 * Created on 2018/6/8 22:47
 */
@RestController("/person")
public class PersonController {
    @Resource
    private PersonService personService;

    @Resource
    private PersonRepository personRepository;

    @GetMapping
    public ResponseEntity<List<Person>> getAllUser() {
        List<Person> persons = new ArrayList<>();
        personRepository.findAll().forEach(person -> persons.add(person));
        return ResponseEntity.ok(persons);
    }

    @PostMapping
    public ResponseEntity<String> addUser(@RequestBody Person person) {
        person = personService.addPerson(person);
        return ResponseEntity.ok(person.getId().toString());
    }
}
