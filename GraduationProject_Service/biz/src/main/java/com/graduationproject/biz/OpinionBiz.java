package com.graduationproject.biz;


import com.graduationproject.entity.Opinion;

import java.util.List;

public interface OpinionBiz {

    void add(Opinion opinion);
    void edit(Opinion opinion);
    void remove(String username);
    Opinion get(String username);
    List<Opinion> getAll();
}
