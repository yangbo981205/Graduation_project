package com.graduationproject.controller;

import com.graduationproject.biz.GlobalBiz;
import com.graduationproject.entity.Admin;
import com.graduationproject.entity.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
@Controller("globalController")
@RequestMapping("/login")
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
        return "users_self";
    }

    @RequestMapping("/self")
    public String self(){
        return "users_self";
    }

    @RequestMapping("/users_quit")
    public String quit(HttpSession httpSession){
        httpSession.setAttribute("users",null);
        return "redirect:to_login";
    }

    @RequestMapping("/to_change_password")
    public String to_change_password(){
        return "users_change_password";
    }
    @RequestMapping("/users_change_password")
    public String change_password(HttpSession httpSession, @RequestParam String password, @RequestParam String newPassword1,@RequestParam String newPassword2 ){
        Users users = (Users)httpSession.getAttribute("users");
        if(users.getPassword().equals(password)){
            if(newPassword1.equals(newPassword2)){
                users.setPassword(newPassword2);
                globalBiz.users_changPassword(users);
                return "redirect:to_login";
            }
        }
        return "redirect:to_change_password";
    }



    @RequestMapping("/admin_to_login")
    public String admin_to_login(){
        return "admin_login";
    }
    @RequestMapping("/admin_login")
    public String admin_login(HttpSession httpSession, @RequestParam String admin_number, @RequestParam String admin_password){
        Admin admin = globalBiz.admin_login(admin_number, admin_password);
        if(admin==null){
            return "redirect:admin_to_login";
        }
        httpSession.setAttribute("admin",admin);
        return "redirect:admin_self";
    }

    @RequestMapping("/admin_self")
    public String admin_self(){
        return "admin_self";
    }

    @RequestMapping("/admin_quit")
    public String admin_quit(HttpSession httpSession){
        httpSession.setAttribute("admin",null);
        return "redirect:admin_to_login";
    }

    @RequestMapping("/admin_to_change_password")
    public String admin_to_change_password(){
        return "admin_change_password";
    }
    @RequestMapping("/admin_change_password")
    public String admin_change_password(HttpSession httpSession, @RequestParam String password, @RequestParam String newPassword3,@RequestParam String newPassword4 ){
       Admin admin = (Admin) httpSession.getAttribute("admin");
        if(admin.getAdmin_password().equals(password)){
            if(newPassword3.equals(newPassword4)){
                admin.setAdmin_password(newPassword4);
                globalBiz.admin_changPassword(admin);
                return "redirect:admin_to_login";
            }
        }
        return "redirect:admin_to_change_password";
    }

}
