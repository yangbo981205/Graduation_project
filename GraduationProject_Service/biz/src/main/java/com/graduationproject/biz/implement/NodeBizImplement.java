package com.graduationproject.biz.implement;

import com.graduationproject.biz.NodeBiz;
import com.graduationproject.dao.NodeDao;
import com.graduationproject.entity.Node;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("nodeBiz")
public class NodeBizImplement implements NodeBiz {

    @Qualifier("nodeDao")
    @Autowired
    private NodeDao nodeDao;

    @Override
    public void add(Node node) {
        nodeDao.insert(node);
    }

    @Override
    public void edit(Node node) {
        nodeDao.update(node);
    }

    @Override
    public void remove(String macaddr) {
        nodeDao.delete(macaddr);
    }

    @Override
    public Node get(String macaddr) {
        return nodeDao.select(macaddr);
    }

    @Override
    public List<Node> getAll() {
        return nodeDao.selectAll();
    }
}
