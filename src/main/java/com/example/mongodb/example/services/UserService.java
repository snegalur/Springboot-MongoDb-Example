package com.example.mongodb.example.services;


import com.example.mongodb.example.document.User;
import com.example.mongodb.example.model.UserDto;

import java.util.List;

public interface UserService {
    List<UserDto> findAll();

    UserDto getById(int id);

    UserDto addUser(UserDto userdto);

    void deleteAllUser();
}
