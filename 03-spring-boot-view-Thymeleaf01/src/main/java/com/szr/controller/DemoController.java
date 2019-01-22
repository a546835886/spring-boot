package com.szr.controller;

import com.szr.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

/**
 * Thymeleaf入门案例
 */
@Controller
public class DemoController {

    @RequestMapping("/show")
    public String showInfo(Model model){
        model.addAttribute("msg","Thymeleaf 第一个案例");
        model.addAttribute("key",new Date());
        return "index";

    }

    @RequestMapping("/show2")
    public String showInfo2(Model model){
        model.addAttribute("sex","女");
        model.addAttribute("id","3");
        return "index2";
    }

    @RequestMapping("/show3")
    public  String showInfo3(Model model){
        List<User> list = new ArrayList<>();
        list.add(new User(1,"张三",20));
        list.add(new User(2,"李四",22));
        list.add(new User(3,"王五",24));
        model.addAttribute("list", list);

        return "index3";
    }

    @RequestMapping("/show4")
    public String showInfo4(Model model){
        Map<String, User> map = new HashMap<>();
        map.put("u1",new User(1,"张三",20));
        map.put("u2",new User(2,"李四",30));
        map.put("u3",new User(3,"王五",40));
        model.addAttribute("map",map);
        return "index4";
    }

    /*
    域对象操作HttpServletRequet、HttpSession、ServletContext
     */
    @RequestMapping("/show5")
    public String showInfo5(HttpServletRequest request, Model model){
        request.setAttribute("req","HttpServletRequest");
        request.getSession().setAttribute("session","HttpSession");
        request.getSession().getServletContext().setAttribute("app","Application");
        return "index5";
    }

}
