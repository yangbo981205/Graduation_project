package com.graduationproject.controller;


import com.graduationproject.biz.NodeBiz;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

@Controller("nodeController")
@RequestMapping("/node")
public class NodeController {

    @Autowired
    private NodeBiz nodeBiz;

    /*
    * 只对管理员用户做展示;
    * 在连接硬件传数据处，读取json对象，进行数据库的增删改操作；
    * 在web页面上只做展示
    * */
    @RequestMapping("/list")
    public String list(Map<String,Object> map){
        map.put("list",nodeBiz.getAll());
        return "node_list";
    }

}
