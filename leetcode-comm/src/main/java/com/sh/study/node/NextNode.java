package com.sh.study.node;

/**
 * 相比于 Node 而言，多了一个next，指向相邻的next的指针
 *
 * @author zhouwenchen
 * @date 20210305
 */
public class NextNode {
    public int val;
    public NextNode left;
    public NextNode right;
    public NextNode next;

    public NextNode(int val) {
        this.val = val;
    }

    public NextNode(int val, NextNode left, NextNode right, NextNode next) {
        this.val = val;
        this.left = left;
        this.right = right;
        this.next = next;
    }
}
