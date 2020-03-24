package com.graduationproject.controller;

import com.graduationproject.biz.UsersBiz;
import com.graduationproject.entity.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

@Controller("usersController")
@RequestMapping("/users")
public class UsersController {

    @Autowired
    private UsersBiz usersBiz;

    @RequestMapping("/list")
    public String list(Map<String,Object> map){
        map.put("list",usersBiz.getAll());
        return "users_list";
    }

    @RequestMapping("/to_add")
    public String toAdd(Map<String,Object> map){
        map.put("users",new Users());
        return "users_add";
    }

    @RequestMapping("/add")
    public String Add(Users users){
        usersBiz.add(users);
        return "redirect:list";
    }

    @RequestMapping(value = "/to_update",params = "username")
    public String toUpdate(String username,Map<String,Object> map){
        map.put("users",usersBiz.get(username));
        return "users_update";
    }

    @RequestMapping("/update")
    public String Update(Users users){
        usersBiz.edit(users);
        return "redirect:list";
    }

    @RequestMapping(value = "/remove",params = "username")
    public String toRemove(String username){
        usersBiz.remove(username);
        return "redirect:list";
    }

}
