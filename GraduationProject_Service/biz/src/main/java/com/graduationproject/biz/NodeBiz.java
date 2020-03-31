package com.graduationproject.biz;


import com.graduationproject.entity.Node;

import java.util.List;

public interface NodeBiz {

    void add(Node node);
    void edit(Node node);
    void remove(String macaddr);
    Node get(String macaddr);
    List<Node> getAll();
}
