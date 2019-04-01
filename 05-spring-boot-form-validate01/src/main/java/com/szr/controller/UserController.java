package com.szr.controller;

import com.szr.pojo.User1;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
public class UserController {

    @RequestMapping("/addUser")
    public String showPage(@ModelAttribute("aa") User1 user1){
        return "add";
    }

    /**
     * 完成用户添加
     * @Valid 开启对User1对象的数据校验
     * BindingResult：封装了数据校验的结果 key名称和@Valid中一致
     */
    @RequestMapping("/save")
    public String saveUser(@ModelAttribute("aa") @Valid User1 user1, BindingResult result){
        if (result.hasErrors()){
            return "add";
        }

        System.out.println(user1);
        return "ok";
    }
}
