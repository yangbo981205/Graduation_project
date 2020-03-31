package com.graduationproject.biz.implement;

import com.graduationproject.biz.ComfortableBiz;
import com.graduationproject.dao.ComfortableDao;
import com.graduationproject.entity.Comfortable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;


@Service("comfortableBiz")
public class ComfortableBizImplement implements ComfortableBiz {

    @Qualifier("comfortableDao")
    @Autowired
    private ComfortableDao comfortableDao;

    @Override
    public void add(Comfortable comfortable) {
        comfortableDao.insert(comfortable);
    }

    @Override
    public void edit(Comfortable comfortable) {
        comfortableDao.update(comfortable);
    }

    @Override
    public void remove(String username) {
        comfortableDao.delete(username);
    }

    @Override
    public Comfortable get(String username) {
        return comfortableDao.select(username);
    }

    @Override
    public List<Comfortable> getAll() {
        return comfortableDao.selectAll();
    }
}
