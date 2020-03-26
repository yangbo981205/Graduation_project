package com.graduationproject.dao;

import com.graduationproject.entity.Opinion;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("opinionDao")
public interface OpinionDao {

    void insert(Opinion opinion);
    void update(Opinion opinion);
    void delete(String username);
    Opinion select(String username);
    List<Opinion> selectAll();
}
