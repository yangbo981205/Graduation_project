package com.graduationproject.biz;

import com.graduationproject.entity.Environment;

import java.util.List;

public interface EnvironmentBiz {

    void add(Environment environment);
    void edit(Environment environment);
    void remove(String time);
    Environment get(String time);
    List<Environment> getAll();
}
