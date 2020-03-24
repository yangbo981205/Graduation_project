package com.graduationproject.controller;

import com.graduationproject.biz.GlobalBiz;
import com.graduationproject.entity.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
@Controller("globalController")
public class GlobalController {
    @Autowired
    private GlobalBiz globalBiz;

    @RequestMapping("/to_login")
    public String to_login(){
        return "users_login";
    }
    @RequestMapping("/users_login")
    public String login(HttpSession httpSession, @RequestParam String username, @RequestParam String password){
        Users users = globalBiz.users_login(username, password);
        if(users==null){
            return "redirect:to_login";
        }
        httpSession.setAttribute("users",users);
        return "redirect:self";
    }

    @RequestMapping("/self")
    public String self(){
        return "self";
    }

}
