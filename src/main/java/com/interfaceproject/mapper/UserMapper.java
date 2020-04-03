package com.interfaceproject.mapper;

import com.interfaceproject.entry.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface UserMapper {

    @Select("select * from user")
    public List< User > queryUser();

    @Select("select * from user where id=1")
    List< User> getID();
}
