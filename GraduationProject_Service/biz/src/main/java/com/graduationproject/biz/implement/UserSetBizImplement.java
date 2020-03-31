package com.graduationproject.biz.implement;

import com.graduationproject.biz.UserSetBiz;
import com.graduationproject.dao.UserSetDao;
import com.graduationproject.entity.UserSet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;


@Service("userSetBiz")
public class UserSetBizImplement implements UserSetBiz {

    @Qualifier("userSetDao")
    @Autowired
    private UserSetDao userSetDao;

    @Override
    public void add(UserSet userSet) {
        userSetDao.insert(userSet);
    }

    @Override
    public void edit(UserSet userSet) {
        userSetDao.update(userSet);
    }

    @Override
    public void remove(String username) {
        userSetDao.delete(username);
    }

    @Override
    public UserSet get(String username) {
        return userSetDao.select(username);
    }

    @Override
    public List<UserSet> getAll() {
        return userSetDao.selectAll();
    }
}
