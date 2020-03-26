package com.graduationproject.dao;

import com.graduationproject.entity.Comfortable;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("comfortableDao")
public interface ComfortableDao {

    void insert(Comfortable comfortable);
    void update(Comfortable comfortable);
    void delete(String username);
    Comfortable select(String username);
    List<Comfortable> selectAll();
}
