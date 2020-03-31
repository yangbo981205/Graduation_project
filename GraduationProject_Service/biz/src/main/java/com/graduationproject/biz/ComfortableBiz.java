package com.graduationproject.biz;



import com.graduationproject.entity.Comfortable;

import java.util.List;

public interface ComfortableBiz {

    void add(Comfortable comfortable);
    void edit(Comfortable comfortable);
    void remove(String username);
    Comfortable get(String username);
    List<Comfortable> getAll();

}
