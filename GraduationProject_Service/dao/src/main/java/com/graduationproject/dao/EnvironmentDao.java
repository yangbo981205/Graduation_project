package com.graduationproject.dao;

import com.graduationproject.entity.Environment;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("environmentDao")
public interface EnvironmentDao {

    void insert(Environment environment);
    void update(Environment environment);
    void delete(String time);
    Environment select(String time);
    List<Environment> selectAll();
    List<Environment> selectLimit();
}
