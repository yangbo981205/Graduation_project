package com.graduationproject.biz;

import com.graduationproject.entity.Users;

import java.util.List;

public interface UsersBiz {

    void add(Users users);
    void edit(Users users);
    void remove(String username);
    Users get(String username);
    List<Users> getAll();

}
