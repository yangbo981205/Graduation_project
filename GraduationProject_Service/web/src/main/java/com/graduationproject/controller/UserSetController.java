package com.graduationproject.controller;


import com.graduationproject.biz.UserSetBiz;
import com.graduationproject.entity.UserSet;
import com.graduationproject.entity.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.Map;

@Controller("userSetController")
@RequestMapping("/userSet")
public class UserSetController {

    @Autowired
    private UserSetBiz userSetBiz;

    @RequestMapping("/list")
    public String list(Map<String,Object> map){
        map.put("list",userSetBiz.getAll());
        return "user_set_list";
    }

    @RequestMapping("/self")
    public String self(HttpSession httpSession){
        Users users = (Users) httpSession.getAttribute("users");
        UserSet userSet = userSetBiz.get(users.getUsername());
        httpSession.setAttribute("userSet",userSet);
        return "user_set_self";
    }
}
