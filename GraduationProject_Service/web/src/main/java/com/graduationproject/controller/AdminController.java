package com.graduationproject.controller;

import com.graduationproject.biz.AdminBiz;
import com.graduationproject.entity.Admin;
import com.graduationproject.global.Contants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

@Controller("adminController")
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private AdminBiz adminBiz;

    @RequestMapping("/list")
    public String list(Map<String,Object> map){
        map.put("list",adminBiz.getAll());
        return "admin_list";
    }

    @RequestMapping("/to_add")
    public String toAdd(Map<String,Object> map){
        map.put("admin",new Admin());
        map.put("select_sex", Contants.getSex());
        map.put("select_root", Contants.getRoot());
        return "admin_add";
    }

    @RequestMapping("/add")
    public String Add(Admin admin){
        adminBiz.add(admin);
        return "redirect:list";
    }

    @RequestMapping(value = "/to_update",params = "admin_number")
    public String toUpdate(String admin_number,Map<String,Object> map){
        map.put("admin",adminBiz.get(admin_number));
        map.put("select_sex", Contants.getSex());
        map.put("select_root", Contants.getRoot());
        return "admin_update";
    }

    @RequestMapping("/update")
    public String Update(Admin admin){
        adminBiz.edit(admin);
        return "redirect:list";
    }

    @RequestMapping(value = "/remove",params = "admin_number")
    public String toRemove(String admin_number){
        adminBiz.remove(admin_number);
        return "redirect:list";
    }

}
