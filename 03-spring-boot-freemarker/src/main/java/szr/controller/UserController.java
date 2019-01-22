package szr.controller;

import szr.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

/**
 * SpringBoot整合jsp
 */

@Controller
public class UserController {

    /*
     *  处理请求产生数据
     */
    @RequestMapping("/showUser")
    public String showUser(Model model){
        List<User> list = new ArrayList<>();
        list.add(new User(1,"张三",20));
        list.add(new User(2,"李四",21));
        list.add(new User(3,"王五",22));

        System.out.println("============="+list.size()+"=============");
        //需要一个Model对象
        model.addAttribute("list",list);
        //跳转视图
        return "userList";
    }
}
