package com.graduationproject.biz;

import com.graduationproject.entity.Admin;

import java.util.List;

public interface AdminBiz {

    void add(Admin admin);
    void edit(Admin admin);
    void remove(String admin_number);
    Admin get(String admin_number);
    List<Admin> getRoot(String admin_root);
    List<Admin> getAll();

}
