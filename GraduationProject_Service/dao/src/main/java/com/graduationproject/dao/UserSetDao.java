package com.graduationproject.dao;

import com.graduationproject.entity.UserSet;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("userSetDao")
public interface UserSetDao {

    void insert(UserSet userSet);
    void update(UserSet userSet);
    void delete(String username);
    UserSet select(String username);
    List<UserSet> selectAll();
}
