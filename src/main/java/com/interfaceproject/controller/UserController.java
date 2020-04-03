package com.interfaceproject.controller;

import com.interfaceproject.entry.User;
import com.interfaceproject.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {
    @Autowired
    private UserService serviceUser;
    @RequestMapping("/api/user/all")
    public List< User > queryUser(){
        return serviceUser.queryUser();
    }
    @RequestMapping("/api/1")
    public  List<User> getID(){
        return serviceUser.getID();
    }
}
