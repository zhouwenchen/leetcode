package com.leetcode.lxj.dataconstruct.linkedlist.test;

import com.leetcode.lxj.dataconstruct.linkedlist.entity.SingleLinkedList;

/**
 * 单链表
 */
public class SingleLinkedListTest {
    public static void main(String[] args) {
        int[] arr = {1,4,2,5,7,236,236,35622,63,747,5437,346};
        SingleLinkedList<Integer> list = new SingleLinkedList<>();
        for (int j : arr) {
            list.add(j);
        }
        list.printSelf();
        /*System.out.println(list.remove(346).data);
        list.printSelf();
        list.add(876);
        list.add(83136);
        list.printSelf();*/
        list.reverse2();
        list.printSelf();
    }

}
