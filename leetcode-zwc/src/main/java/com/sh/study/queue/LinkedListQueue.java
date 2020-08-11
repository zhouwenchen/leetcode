package com.sh.study.queue;

import com.sh.study.node.ListNode;

/**
 * 用链表实现一个链式队列
 * @Author zhouwenchen
 * @Data 2020/8/11/14
 **/
public class LinkedListQueue {

    private ListNode head;
    private ListNode tail;
    private int size;

    public LinkedListQueue(){
        head = null;
        tail = null;
        size = 0;
    }

    public int getSize(){
        return size;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public void enqueue(int val){
        if(tail == null){
            tail = new ListNode(val);
            head = tail;
        }else {
            tail.next = new ListNode(val);
            tail = tail.next;
        }
        size++;
    }

    public int dequeue(){
        if(isEmpty()){
            return -1;
        }
        ListNode resultNode = head;
        head = head.next;
        // 链表中仅有一个值时
        if(head == null){
            tail = null;
        }
        size--;
        return resultNode.val;
    }

    public int getFront(){
        if(isEmpty()){
            return -1;
        }
        return head.val;
    }

    public static void main(String[] args) {
        LinkedListQueue queue = new LinkedListQueue();
        for(int i = 9; i < 10; i++){
            queue.enqueue(i);
        }
        System.out.println(queue.getSize());
        System.out.println(queue.getFront());
        System.out.println(queue.dequeue());
        System.out.println(queue.getFront());
        System.out.println(queue.getSize());
    }
}
