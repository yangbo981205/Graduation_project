package com.graduationproject.controller;


import com.graduationproject.biz.OpinionBiz;
import com.graduationproject.entity.Opinion;
import com.graduationproject.entity.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

@Controller("opinionController")
@RequestMapping("/opinion")
public class OpinionController {

    @Autowired
    private OpinionBiz opinionBiz;

    @RequestMapping("/list_users")
    public String list_admin(Map<String,Object> map){
        map.put("list",opinionBiz.getAll());
        return "opinion_list_users";
    }

    @RequestMapping("/to_add")
    public String toAdd(HttpSession httpSession, Map<String,Object> map){
        Users users = (Users) httpSession.getAttribute("users");
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        Opinion opinion=new Opinion();
        opinion.setTime(simpleDateFormat.format(new Date()));
        opinion.setUsername(users.getUsername());
        map.put("opinion",opinion);
        return "opinion_add";
    }

    @RequestMapping("/add")
    public String Add(Opinion opinion){
        opinionBiz.add(opinion);
        return "redirect:list_users";
    }

    @RequestMapping("/list_admin")
    public String list_users(Map<String,Object> map){
        map.put("list",opinionBiz.getAll());
        return "opinion_list_admin";
    }
}
