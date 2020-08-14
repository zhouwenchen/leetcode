package com.sh.study.exercise.first;

import java.util.LinkedList;
import java.util.PriorityQueue;

/**
 * 用户 addfirst  和 addlast 这套新的api改写 Deque 的代码
 * 使用  LinkedList 就可以实现队列的  FIFO
 *
 * @Author zhouwenchen
 * @Data 2020-08-2020/8/7-17
 **/
public class DueueDemo {

    private static LinkedList<Integer> listlist = new LinkedList<>();

    public void addFirst(Integer value) {
        listlist.addFirst(value);
    }

    public void addLast(Integer value) {
        listlist.addLast(value);
    }

    public static void main(String[] args) {
        DueueDemo demo = new DueueDemo();
        demo.addFirst(1);
        demo.addFirst(2);
        demo.addFirst(3);
        demo.addLast(4);
        System.out.println(listlist);


        PriorityQueue priorityQueue = new PriorityQueue();
        priorityQueue.add(1);
        priorityQueue.add(2);
    }
}
