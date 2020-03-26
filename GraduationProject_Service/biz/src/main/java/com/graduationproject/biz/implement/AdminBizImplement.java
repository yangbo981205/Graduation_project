package com.graduationproject.biz.implement;

import com.graduationproject.biz.AdminBiz;
import com.graduationproject.dao.AdminDao;
import com.graduationproject.entity.Admin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("adminBiz")
public class AdminBizImplement implements AdminBiz {

    @Qualifier("adminDao")
    @Autowired
    private AdminDao adminDao;

    @Override
    public void add(Admin admin) {
        adminDao.insert(admin);
    }

    @Override
    public void edit(Admin admin) {
        adminDao.update(admin);
    }

    @Override
    public void remove(String admin_number) {
        adminDao.delete(admin_number);
    }

    @Override
    public Admin get(String admin_number) {
        return adminDao.select(admin_number);
    }

    @Override
    public List<Admin> getRoot(String admin_root) {
        return adminDao.selectRoot(admin_root);
    }

    @Override
    public List<Admin> getAll() {
        return adminDao.selectAll();
    }
}
