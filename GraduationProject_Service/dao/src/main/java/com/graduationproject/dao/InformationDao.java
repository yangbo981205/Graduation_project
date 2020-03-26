package com.graduationproject.dao;

import com.graduationproject.entity.Information;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("informationDao")
public interface InformationDao {

    void insert(Information information);
    void update(Information information);
    void delete(String admin_number);
    Information select(String admin_number);
    List<Information> selectAll();
}
