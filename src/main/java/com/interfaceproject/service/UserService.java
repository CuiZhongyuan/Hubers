package com.interfaceproject.service;


import com.interfaceproject.entry.User;
import com.interfaceproject.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    /**
     * test
     */
    @Autowired
    private UserMapper userMapper;

    public List< User > queryUser() {
        return userMapper.queryUser();
    }

    public List< User> getID() {
        return userMapper.getID();
    }
}
