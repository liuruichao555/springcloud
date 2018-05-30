package com.liuruichao.jersey.controller;

import org.springframework.stereotype.Component;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

/**
 * UserController
 *
 * @author liuruichao
 * Created on 2018/5/30 21:44
 */
@Path("/user")
@Component
public class UserController {
    @GET
    public String getUser() {
        return "getUser";
    }
}
