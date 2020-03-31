package com.graduationproject.biz.implement;

import com.graduationproject.biz.EnvironmentBiz;
import com.graduationproject.dao.EnvironmentDao;
import com.graduationproject.entity.Environment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("environmentBiz")
public class EnvironmentBizImplement implements EnvironmentBiz {

    @Qualifier("environmentDao")
    @Autowired
    private EnvironmentDao environmentDao;

    @Override
    public void add(Environment environment) {
        environmentDao.insert(environment);
    }

    @Override
    public void edit(Environment environment) {
        environmentDao.update(environment);
    }

    @Override
    public void remove(String time) {
        environmentDao.delete(time);
    }

    @Override
    public Environment get(String time) {
        return environmentDao.select(time);
    }

    @Override
    public List<Environment> getAll() {
        return environmentDao.selectAll();
    }
}
