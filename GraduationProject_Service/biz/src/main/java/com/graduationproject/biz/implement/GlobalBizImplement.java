package com.graduationproject.biz.implement;

import com.graduationproject.biz.GlobalBiz;
import com.graduationproject.dao.AdminDao;
import com.graduationproject.dao.UsersDao;
import com.graduationproject.entity.Admin;
import com.graduationproject.entity.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service("globalBiz")
public class GlobalBizImplement implements GlobalBiz {

    @Qualifier("usersDao")
    @Autowired
    private UsersDao usersDao;
    @Qualifier("adminDao")
    @Autowired
    private AdminDao adminDao;


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

    @Override
    public Admin admin_login(String admin_number, String admin_password) {
        Admin admin=adminDao.select(admin_number);
        if(admin!=null&&admin.getAdmin_password().equals(admin_password)){
            return admin;
        }
        return null;
    }

    @Override
    public void admin_changPassword(Admin admin) {
        adminDao.update(admin);
    }
}
