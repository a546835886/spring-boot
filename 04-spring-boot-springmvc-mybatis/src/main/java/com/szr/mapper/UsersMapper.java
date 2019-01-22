package com.szr.mapper;

import com.szr.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UsersMapper {

    void insertUser(User user);

    List<User> findAllUser();

    User selectUserById(Integer id);

    void updateUser(User user);

    void deleteUserById(@Param("id") Integer id);
}
