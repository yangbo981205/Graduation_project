package com.graduationproject.dao;

import com.graduationproject.entity.Admin;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("adminDao")
public interface AdminDao {
    void insert(Admin admin);
    void update(Admin admin);
    void delete(String admin_number);
    Admin select(String admin_number);
    List<Admin> selectAll();
}
