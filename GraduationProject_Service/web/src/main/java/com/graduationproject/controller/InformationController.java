package com.graduationproject.controller;


import com.graduationproject.biz.InformationBiz;
import com.graduationproject.entity.Admin;
import com.graduationproject.entity.Information;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

@Controller("informationController")
@RequestMapping("/information")
public class InformationController {

    @Autowired
    private InformationBiz informationBiz;

    /*
     *通知信息的新增（管理员），查看（普通用户）
     * */
    @RequestMapping("/list_admin")
    public String list_admin(Map<String,Object> map){
        map.put("list",informationBiz.getAll());
        return "information_list_admin";
    }

    @RequestMapping("/to_add")
    public String toAdd(HttpSession httpSession,Map<String,Object> map){
        Admin admin = (Admin) httpSession.getAttribute("admin");
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        Information information=new Information();
        information.setTime(simpleDateFormat.format(new Date()));
        information.setAdmin_number(admin.getAdmin_number());
        map.put("information",information);
        return "information_add";
    }

    @RequestMapping("/add")
    public String Add(Information information){
        informationBiz.add(information);
        return "redirect:list_admin";
    }

    @RequestMapping("/list_users")
    public String list_users(Map<String,Object> map){
        map.put("list",informationBiz.getAll());
        return "information_list_users";
    }

    @RequestMapping(value = "/remove",params = "time")
    public String toRemove(String time){
        informationBiz.remove(time);
        return "redirect:list_admin";
    }

}
