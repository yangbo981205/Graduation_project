package com.graduationproject.controller;


import com.graduationproject.biz.EnvironmentBiz;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

@Controller("environmentController")
@RequestMapping("/environment")
public class EnvironmentController {

    @Autowired
    private EnvironmentBiz environmentBiz;

    /*环境数据从传感器读入，用户和管理员只能查看*/
    @RequestMapping("/list_admin")
    public String list_admin(Map<String,Object> map){
        map.put("list",environmentBiz.getAll());
        return "environment_list_admin";
    }

    @RequestMapping("/list_users")
    public String list_users(Map<String,Object> map){
        map.put("list",environmentBiz.getAll());
        return "environment_list_users";
    }

}
