package com.graduationproject.biz.implement;

import com.graduationproject.biz.InformationBiz;
import com.graduationproject.dao.InformationDao;
import com.graduationproject.entity.Information;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;


@Service("informationBiz")
public class InformationBizImplement implements InformationBiz {

    @Qualifier("informationDao")
    @Autowired
    private InformationDao informationDao;

    @Override
    public void add(Information information) {
        informationDao.insert(information);
    }

    @Override
    public void edit(Information information) {
        informationDao.update(information);
    }

    @Override
    public void remove(String admin_number) {
        informationDao.delete(admin_number);
    }

    @Override
    public Information get(String admin_number) {
        return informationDao.select(admin_number);
    }

    @Override
    public List<Information> getAll() {
        return informationDao.selectAll();
    }
}
