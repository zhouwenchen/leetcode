package com.sh.study.exercise.every.three;

/**
 * 循环队列，多一个空间，
 *
 */
public class MyCircularQueue1 {
    private int front = 0;
    private int rear = 0;
    private int[] a = null;
    private int capacity = 0;

    public MyCircularQueue1(int k){
        capacity = k + 1;
        a = new int[k + 1];
    }

    public boolean enQueue(int value) {
        if(isFull()){
            return false;
        }
        a[rear] = value;
        rear = (rear + 1) % capacity;
        return true;
    }

    public boolean deQueue() {
        if(isEmpty()){
            return false;
        }
        front = (front + 1) % capacity;
        return true;
    }

    public int Front() {
       return isEmpty()? -1: a[front];
    }

    public int Rear() {
        return isEmpty()? -1: a[(rear - 1 + capacity) % capacity];
    }

    public boolean isEmpty() {
        return rear == front;
    }

    public boolean isFull() {
        return (rear + 1) % capacity == front;
    }
}
