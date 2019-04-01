package com.szr.springbootfreemarker.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.Map;

@Controller
@RequestMapping("/freemarker")
public class FreemarkerConroller {

    @RequestMapping("/index")
    public String web(Map<String, Object> model) {
        model.put("message","freemar测试");
        model.put("content","测试freemar创建及如何取值");
        // 返回的内容就是templetes下面文件的名称
        return "index";
    }
}