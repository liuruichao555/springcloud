package com.liuruichao.ldap.controller;

import com.liuruichao.ldap.model.Person;
import com.liuruichao.ldap.service.PersonService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.naming.InvalidNameException;
import java.util.ArrayList;
import java.util.List;

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

//    @GetMapping
//    public ResponseEntity<String> getAllUser() throws InvalidNameException {
//        return ResponseEntity.ok(personService.getPerson().toString());
//    }

    @GetMapping
    public ResponseEntity<String> login() throws InvalidNameException {
        return personService.login("lrc6", "liuruichao123");
    }

    @PostMapping
    public ResponseEntity<String> addUser(@RequestBody Person person) {
        person = personService.addPerson(person);
        return ResponseEntity.ok(person.getId().toString());
    }
}
