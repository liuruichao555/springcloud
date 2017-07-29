package com.liuruichao;

import java.util.Arrays;

/**
 * User
 *
 * @author liuruichao
 * Created on 2017/7/29 21:17
 */
public class User {
    private String name;

    private String args;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getArgs() {
        return args;
    }

    public void setArgs(String args) {
        this.args = args;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", args='" + args + '\'' +
                '}';
    }
}
