package com.szr.controller;

import com.szr.pojo.User;
import com.szr.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/users")
public class UsersController {

    @Autowired
    private UsersService usersServiceImpl;

    /**
     * 页面跳转
     */
    @RequestMapping("/{page}")
    public String showPage(@PathVariable String page){
        return page;
    }

    /**
     * 添加用户方法啊
     *
     */
    @RequestMapping("/addUser")
    public String addUser(User user){
        System.out.println(user.getName()+"=="+user.getAge());
        usersServiceImpl.addUser(user);
        return "ok";
    }

    /**
     * 查询用户数据
     */
    @RequestMapping("/findAllUser")
    public String findAllUser(Model model){
        List<User> allUser = usersServiceImpl.findAllUser();
        model.addAttribute("list",allUser);
        return "allUser";
    }

    /**
     * 根据用户id查询用户
     */
    @RequestMapping("/findUserById")
    public String findUserById(Model model,Integer id){
        User user = usersServiceImpl.findUserById(id);
        model.addAttribute("user",user);
        return "updateUser";
    }

    /**
     * 更新用户信息
     */
    @RequestMapping("/editUser")
    public String editUser(User user){
        usersServiceImpl.updateUser(user);
        return "ok";
    }

    /**
     * 删除用户信息
     */
    @RequestMapping("/deleteUserById")
    public String deleteUserById(Integer id){
        usersServiceImpl.deleteUserById(id);
        return "ok";
    }
}
