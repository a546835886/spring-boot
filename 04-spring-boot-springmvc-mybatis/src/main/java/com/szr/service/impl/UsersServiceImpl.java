package com.szr.service.impl;

import com.szr.mapper.UsersMapper;
import com.szr.pojo.User;
import com.szr.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
@Transactional
public class UsersServiceImpl implements UsersService{

    @Resource
    private UsersMapper usersMapper;

    @Override
    public void addUser (User user){
        usersMapper.insertUser(user);
    }

    @Override
    public List<User> findAllUser (){

        return usersMapper.findAllUser();
    }

    @Override
    public User findUserById (Integer id){
        return usersMapper.selectUserById(id);
    }

    @Override
    public void updateUser (User user){
        usersMapper.updateUser(user);
    }

    @Override
    public void deleteUserById (Integer id){
        usersMapper.deleteUserById(id);
    }
}
