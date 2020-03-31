package com.graduationproject.biz;


import com.graduationproject.entity.Information;

import java.util.List;

public interface InformationBiz {

    void add(Information information);
    void edit(Information information);
    void remove(String admin_number);
    Information get(String admin_number);
    List<Information> getAll();
}
