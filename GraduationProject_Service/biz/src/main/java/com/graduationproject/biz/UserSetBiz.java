package com.graduationproject.biz;


import com.graduationproject.entity.UserSet;

import java.util.List;

public interface UserSetBiz {

    void add(UserSet userSet);
    void edit(UserSet userSet);
    void remove(String username);
    UserSet get(String username);
    List<UserSet> getAll();
}
