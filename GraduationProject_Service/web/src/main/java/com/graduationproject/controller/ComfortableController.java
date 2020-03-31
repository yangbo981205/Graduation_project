package com.graduationproject.controller;


import com.graduationproject.biz.ComfortableBiz;
import com.graduationproject.entity.Comfortable;
import com.graduationproject.entity.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.Map;

@Controller("comfortableController")
@RequestMapping("/comfortable")
public class ComfortableController {

    @Autowired
    private ComfortableBiz comfortableBiz;

    /*管理员查看所有用户*/
    @RequestMapping("/list")
    public String list(Map<String,Object> map){
        map.put("list",comfortableBiz.getAll());
        return "comfortable_all";
    }

    /*用户查看自己*/
    @RequestMapping("/self")
    public String login(HttpSession httpSession){
        Users users = (Users) httpSession.getAttribute("users");
        Comfortable comfortable = comfortableBiz.get(users.getUsername());
        httpSession.setAttribute("comfortable",comfortable);
        return "comfortable_self";
    }

    /*增加在移动端，这里只写更改*/
    @RequestMapping(value = "/to_update",params = "username")
    public String toUpdate(String username,Map<String,Object> map){
        map.put("comfortable",comfortableBiz.get(username));
        return "comfortable_update";
    }

    @RequestMapping("/update")
    public String Update(Comfortable comfortable){
        comfortableBiz.edit(comfortable);
        return "comfortable_self";
    }

}
