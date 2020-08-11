package com.sh.study.queue;

import java.lang.reflect.Array;

/**
 * 用数组实现一个顺序队列
 *
 * @Author zhouwenchen
 * @Data 2020/8/11/11
 **/
public class ArrayQueue {
    private String[] items;
    private int n = 0;

    private int head = 0;
    private int tail = 0;

    public ArrayQueue(int capacity) {
        items = new String[capacity];
        n = capacity;
    }

    /**
     * 入队操作
     */
    public boolean enqueue(String item) {
        if (tail == n) {
            return false;
        }
        items[tail] = item;
        ++tail;
        return true;
    }

    /**
     * 出队列操作
     */
    public String dequeue() {
        if (head == tail) {
            return null;
        }
        String result = items[head];
        ++head;
        return result;
    }

    /**
     * 优化入队操作的逻辑，如果此时tail 已经达到了队尾，但是head ！= 0 ，说明队列是没有满的，所以移动所有的数据到队首
     */
    public boolean enqueue1(String item){
        // 表示队列队尾已经没有插入的结尾了
        if(tail == n){
            // 表示队列满了
            if(head == 0){
                return false;
            }
            for(int i = head; i < tail;i++){
                items[i-head] = items[i];
            }
            // 搬移完之后重新更新 head 和 tail
            tail -= head;
            head = 0;
        }
        items[tail] = item;
        ++tail;
        return true;
    }

    public static void main(String[] args) {
//        ArrayQueue queue = new ArrayQueue(3);
//        System.out.println(queue.enqueue("a"));
//        System.out.println(queue.enqueue("b"));
//        System.out.println(queue.enqueue("c"));
//        System.out.println(queue.enqueue("d"));
//        System.out.println(queue.dequeue());
//        System.out.println(queue.enqueue("e"));

        ArrayQueue queue = new ArrayQueue(3);
        System.out.println(queue.enqueue1("a"));
        System.out.println(queue.enqueue1("b"));
        System.out.println(queue.enqueue1("c"));
        System.out.println(queue.enqueue1("d"));
        System.out.println(queue.dequeue());
        System.out.println(queue.enqueue1("e"));
    }
}
