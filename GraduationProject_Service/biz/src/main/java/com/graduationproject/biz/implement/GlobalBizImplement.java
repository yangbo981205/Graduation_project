package com.graduationproject.biz.implement;

import com.graduationproject.biz.GlobalBiz;
import com.graduationproject.dao.UsersDao;
import com.graduationproject.entity.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service("globalBiz")
public class GlobalBizImplement implements GlobalBiz {

    @Qualifier("usersDao")
    @Autowired
    private UsersDao usersDao;

    @Override
    public Users users_login(String username, String password) {
        Users users=usersDao.select(username);
        if(users!=null&&users.getPassword().equals(password)){
            return users;
        }
        return null;
    }

    @Override
    public void users_changPassword(Users users) {
        usersDao.update(users);
    }
}
