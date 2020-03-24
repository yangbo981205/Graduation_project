package com.graduationproject.global;

import java.util.ArrayList;
import java.util.List;

public class Contants {

    /*常量的定义*/
    //身份
    public static final String USER_ADMIN="管理员";
    public static final String USER_COMMON="普通用户";
    public static List<String> getIdentity(){
        List<String> list_identity=new ArrayList<>();
        list_identity.add(USER_ADMIN);
        list_identity.add(USER_COMMON);
        return list_identity;
    }

    public static List<String> getSex(){
        List<String> list_sex=new ArrayList<>();
        list_sex.add("男");
        list_sex.add("女");
        return list_sex;
    }

    public static List<String> getRoot(){
        List<String> list_root=new ArrayList<>();
        list_root.add("0");
        list_root.add("1");
        list_root.add("2");
        list_root.add("3");
        list_root.add("4");
        list_root.add("5");
        return list_root;
    }


}
