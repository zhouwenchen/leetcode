package com.sh.study.node;

/**
 * 树中，记录左右节点和父亲节点的值
 */
public class ParentTreeNode {
    public ParentTreeNode parent, left, right;
    public int val;

    public ParentTreeNode(int val){
        this.parent = null;
        this.left = null;
        this.right = null;
        this.val = val;
    }
}
