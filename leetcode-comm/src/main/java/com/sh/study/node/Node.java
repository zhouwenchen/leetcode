package com.sh.study.node;

import java.util.List;

/**
 * N 叉树的节点信息
 *
 * @Author zhouwenchen
 * @Data 2020/8/14/14
 **/
public class Node {
    public int val;
    public List<Node> children;

    public Node() {
    }

    public Node(int val) {
        this.val = val;
    }

    public Node(int val, List<Node> children) {
        this.val = val;
        this.children = children;
    }
}