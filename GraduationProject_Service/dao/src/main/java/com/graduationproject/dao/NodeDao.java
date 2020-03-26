package com.graduationproject.dao;

import com.graduationproject.entity.Node;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("nodeDao")
public interface NodeDao {
    void insert(Node node);
    void update(Node node);
    void delete(String macaddr);
    Node select(String macaddr);
    List<Node> selectAll();
}
