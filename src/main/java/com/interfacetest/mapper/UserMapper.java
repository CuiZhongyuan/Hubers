package com.interfacetest.mapper;


import com.interfacetest.entry.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserMapper {

    User Sel(int id);
}