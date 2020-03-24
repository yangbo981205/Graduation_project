package com.graduationproject.dao;

import com.graduationproject.entity.Users;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("usersDao")
public interface UsersDao {
    void insert(Users users);
    void update(Users users);
    void delete(String username);
    Users select(String username);
    List<Users> selectAll();
}
