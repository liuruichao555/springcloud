package com.liuruichao.ldap.service;

import com.liuruichao.ldap.model.Person;
import com.liuruichao.ldap.repository.PersonRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.ldap.query.LdapQuery;
import org.springframework.ldap.query.LdapQueryBuilder;
import org.springframework.stereotype.Service;
import org.springframework.util.Base64Utils;

import javax.annotation.Resource;
import javax.naming.InvalidNameException;
import javax.naming.ldap.LdapName;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

/**
 * PersonService
 *
 * @author liuruichao
 * Created on 2018/6/8 22:50
 */
@Service
@Slf4j
public class PersonService {
    @Resource
    private PersonRepository personRepository;

    public Person getPerson() throws InvalidNameException {
        return personRepository.findOne(new LdapName("uid=lrc6,dc=shuaiche,dc=com"));
    }

    public ResponseEntity<String> login(String name, String password) throws InvalidNameException {
        log.info("name: {}, password: {}.", name, password);

        LdapQuery query = LdapQueryBuilder.query().base("dc=shuaiche,dc=com").where("uid").is(name);
        Person person = personRepository.findOne(query);

        if (person != null) {
            // TODO 加密算法可更改, userPassword存储的是108,23,89,10,
            String rawPwd = convert(person.getUserPassword());
            log.info("userPassword: {}, password: {}.", rawPwd, password);
            if (rawPwd.equals(password)) {
                return ResponseEntity.ok(person.toString());
            }
        }

        return ResponseEntity.badRequest().body(null);
    }

    public Person addPerson(Person person) {
        System.out.println("person: " + person);
        person = personRepository.save(person);
        return person;
    }

    private static String convert(String str) {
        String[] tmpList = str.split(",");
        StringBuilder sbu = new StringBuilder();

        for (String aTmpList : tmpList) {
            int num = Integer.valueOf(aTmpList);
            char c = (char) num;
            sbu.append(c);
        }

        return sbu.toString();
    }
}
