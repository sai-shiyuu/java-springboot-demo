package com.hana.demo.mappers;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Mapper;

import com.hana.demo.models.entity.User;

@Mapper
public interface UserMapper {

    User getUserById(Long id);

    ArrayList<User> getUsersByName(String name);

    Integer insertUser(User user);

    Integer updateUser(User user);

    Integer deleteUser(Long id);

}
