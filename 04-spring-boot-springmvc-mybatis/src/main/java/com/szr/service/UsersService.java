package com.szr.service;

import com.szr.pojo.User;

import java.util.List;

public interface UsersService {
    void addUser(User user);

    List<User> findAllUser();

    User findUserById(Integer id);

    void updateUser(User user);

    void deleteUserById(Integer id);

}
