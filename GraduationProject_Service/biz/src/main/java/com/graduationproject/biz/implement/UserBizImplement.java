package com.graduationproject.biz.implement;


import com.graduationproject.biz.UsersBiz;
import com.graduationproject.dao.UsersDao;
import com.graduationproject.entity.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("usersBiz")
public class UserBizImplement implements UsersBiz {

    @Qualifier("usersDao")
    @Autowired
    private UsersDao usersDao;

    @Override
    public void add(Users users) {
        usersDao.insert(users);
    }

    @Override
    public void edit(Users users) {
        usersDao.update(users);
    }

    @Override
    public void remove(String username) {
        usersDao.delete(username);
    }

    @Override
    public Users get(String username) {
        return usersDao.select(username);
    }

    @Override
    public List<Users> getAll() {
        return usersDao.selectAll();
    }
}
