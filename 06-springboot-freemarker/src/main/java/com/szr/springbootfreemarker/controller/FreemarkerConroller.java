package com.szr.springbootfreemarker.controller;

import com.szr.springbootfreemarker.pojo.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.*;

@Controller
@RequestMapping("/freemarker")
public class FreemarkerConroller {

    @Autowired
    Resource resource;

    @RequestMapping("/index")
    public String web(Map<String, Object> model) {
        model.put("message","message=======");
        model.put("content","");
        model.put("date",new Date());
        // 返回的内容就是templetes下面文件的名称
        resource.setName("liuy");
        model.put("resource",resource);
        return "freemarker/test-one";
    }

    @RequestMapping(value ="center")
    public String  center(ModelMap map){
        map.put("users",parseUsers());
        map.put("title","用户列表");
        return "freemarker/center";
    }

    private List<Map> parseUsers(){
        List<Map> list= new ArrayList<>();
        for(int i=0;i<10;i++){
            Map map= new HashMap();
            map.put("name","kevin_"+i);
            map.put("age",10+i);
            map.put("phone","1860291105"+i);
            list.add(map);
        }
        return list;
    }
}