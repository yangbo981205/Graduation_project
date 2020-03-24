package com.graduationproject.biz;

import com.graduationproject.entity.Users;

public interface GlobalBiz {

    Users users_login(String username,String password);
    void users_changPassword(Users users);
}
