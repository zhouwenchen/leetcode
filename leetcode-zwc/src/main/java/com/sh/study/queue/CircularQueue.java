package com.sh.study.queue;

/**
 * 实现一个循环队列
 *
 * @Author zhouwenchen
 * @Data 2020/8/11/11
 **/
public class CircularQueue {
    private String[] items;
    private int n = 0;

    private int head = 0;
    private int tail = 0;

    public CircularQueue(int capacity) {
        items = new String[capacity];
        n = capacity;
    }

    /**
     * 入队操作
     */
    public boolean enqueue(String item) {
        // 队列满了
        if ((tail + 1) % n == head) {
            return false;
        }
        items[tail] = item;
        tail = (tail + 1) % n;
        return true;
    }

    /**
     * 出队操作
     *
     * @return
     */
    public String dequeue() {
        if (head == tail) {
            return null;
        }
        String result = items[head];
        head = (head + 1) % n;
        return result;
    }

    public static void main(String[] args) {
        CircularQueue queue = new CircularQueue(3);
        System.out.println(queue.enqueue("a"));
        System.out.println(queue.enqueue("b"));
        System.out.println(queue.enqueue("c"));
        System.out.println(queue.enqueue("d"));
        System.out.println(queue.dequeue());
        // 注意debug，此时  queue中还是存在 a，b，数据，但是此时 head此时的位置，才表示真正队列中的数据
        System.out.println(queue.enqueue("e"));
    }
}
