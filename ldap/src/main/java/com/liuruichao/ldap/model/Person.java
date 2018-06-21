package com.liuruichao.ldap.model;

import lombok.Data;
import org.springframework.ldap.odm.annotations.Attribute;
import org.springframework.ldap.odm.annotations.DnAttribute;
import org.springframework.ldap.odm.annotations.Entry;
import org.springframework.ldap.odm.annotations.Id;

import javax.naming.Name;

/**
 * Person
 *
 * @author liuruichao
 * Created on 2018/6/8 22:47
 */
@Data
@Entry(base = "ou=people,dc=shuaiche,dc=com", objectClasses = {"uidObject", "person"})
public class Person {
    @Id
    private Name id;

    @DnAttribute(value = "uid", index = 3)
    private String uid;

    @Attribute(name = "cn")
    private String fullName;

    @Attribute(name = "sn")
    private String lastName;

    @Attribute(name = "userPassword")
    private String userPassword;
}