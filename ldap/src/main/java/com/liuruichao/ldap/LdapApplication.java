package com.liuruichao.ldap;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.ldap.repository.config.EnableLdapRepositories;
import org.springframework.ldap.core.ContextSource;
import org.springframework.ldap.core.LdapTemplate;
import org.springframework.ldap.core.support.LdapContextSource;

/**
 * LdapApplication
 *
 * @author liuruichao
 * Created on 2018/6/8 22:45
 */
@Configuration
@SpringBootApplication
@EnableLdapRepositories
public class LdapApplication {
    public static void main(String[] args) {
        SpringApplication.run(LdapApplication.class, args);
    }

    @Bean
    ContextSource contextSource() {

        LdapContextSource ldapContextSource = new LdapContextSource();
        ldapContextSource.setUrl("ldap://127.0.0.1:389");
        ldapContextSource.setUserDn("cn=Manager,dc=shuaiche,dc=com");
        //ldapContextSource.setUserDn("cn=admin");
        ldapContextSource.setPassword("liuruichao123");
        return ldapContextSource;
    }

    @Bean
    LdapTemplate ldapTemplate(ContextSource contextSource) {
        return new LdapTemplate(contextSource);
    }
}
