package com.szr.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.websocket.server.PathParam;

@Controller
public class DemoController {

    @RequestMapping("/{page}")
    public  String showInfo(@PathVariable(value = "page") String page,
                            @RequestParam(value="id", required = false) String id1,
                            @RequestParam(value="name", required = false) String name1,
                            Model model){
        System.out.println(id1+"     "+name1);
        model.addAttribute("msg","1111");
        return page;
    }

//    @RequestMapping("/{page}")
//    public  String showInfo(@PathVariable String page, String id, String name, Model model){
//        System.out.println(id+"     "+name);
//        model.addAttribute("msg","1111");
//        return page;
//    }


    @RequestMapping("/index/{page}")
    public  String showInfo2(@PathVariable String page,String name, Model model){
        System.out.println(name);
        model.addAttribute("msg","1111");
        return page;
    }
}
