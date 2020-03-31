package com.graduationproject.biz.implement;

import com.graduationproject.biz.OpinionBiz;
import com.graduationproject.dao.OpinionDao;
import com.graduationproject.entity.Opinion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;


@Service("opinionBiz")
public class OpinionBizImplement implements OpinionBiz {

    @Qualifier("opinionDao")
    @Autowired
    private OpinionDao opinionDao;

    @Override
    public void add(Opinion opinion) {
        opinionDao.insert(opinion);
    }

    @Override
    public void edit(Opinion opinion) {
        opinionDao.update(opinion);
    }

    @Override
    public void remove(String username) {
        opinionDao.delete(username);
    }

    @Override
    public Opinion get(String username) {
        return opinionDao.select(username);
    }

    @Override
    public List<Opinion> getAll() {
        return opinionDao.selectAll();
    }
}
