package com.sh.study.exercise.every.three;

/**
 * 循环队列
 */
public class MyCircularQueue {

    // 队列中已经使用的元素
    private int used = 0;
    private int front = 0;
    private int rear = 0;
    // 循环队列中存放的元素
    private int capacity = 0;
    // 存储空间
    private int[] a = null;

    public MyCircularQueue(int k) {
        capacity = k;
        a = new int[k];
    }

    /**
     * 入队列
     *
     * @param value
     * @return
     */
    public boolean enQueue(int value) {
        if(isFull()){
            return false;
        }
        a[rear] = value;
        rear = (rear + 1) % capacity;
        used++;
        return true;
    }

    public boolean deQueue() {
        if(isEmpty()){
            return false;
        }
        int result = a[front];
        used--;
        front = (front + 1) % capacity;
        return true;
    }

    public int Front() {
        if(isEmpty()){
            return -1;
        }

        return a[front];
    }

    public int Rear() {
        if(isEmpty()){
            return -1;
        }
        int tail = (rear - 1 + capacity) % capacity;
        return a[tail];
    }

    public boolean isEmpty() {
        return used == 0;
    }

    public boolean isFull() {
        return used == capacity;
    }
}
