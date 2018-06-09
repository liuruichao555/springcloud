package com.liuruichao.ldap.repository;

import com.liuruichao.ldap.model.Person;
import org.springframework.data.ldap.repository.LdapRepository;

/**
 * PersonRepository
 *
 * @author liuruichao
 * Created on 2018/6/8 22:48
 */
public interface PersonRepository extends LdapRepository<Person> {
}
