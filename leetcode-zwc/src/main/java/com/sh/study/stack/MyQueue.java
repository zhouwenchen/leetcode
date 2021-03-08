package com.sh.study.stack;

import java.util.Stack;

/**
 * 232. 用栈实现队列
 * 使用栈实现队列的下列操作：
 *
 * push(x) -- 将一个元素放入队列的尾部。
 * pop() -- 从队列首部移除元素。
 * peek() -- 返回队列首部的元素。
 * empty() -- 返回队列是否为空。
 *
 *
 * 示例:
 *
 * MyQueue queue = new MyQueue();
 *
 * queue.push(1);
 * queue.push(2);
 * queue.peek();  // 返回 1
 * queue.pop();   // 返回 1
 * queue.empty(); // 返回 false
 *
 *
 * 说明:
 *
 * 你只能使用标准的栈操作 -- 也就是只有 push to top, peek/pop from top, size, 和 is empty 操作是合法的。
 * 你所使用的语言也许不支持栈。你可以使用 list 或者 deque（双端队列）来模拟一个栈，只要是标准的栈操作即可。
 * 假设所有操作都是有效的 （例如，一个空的队列不会调用 pop 或者 peek 操作）。
 *
 * @Author zhouwenchen
 * @Data 2020/8/10/19
 **/
public class MyQueue {

    /**  数据入栈操作  */
    private Stack<Integer> dataStack1 = new Stack();
    /**  数据出栈操作 */
    private Stack<Integer> dataStack2 = new Stack();

    /** Initialize your data structure here. */
    public MyQueue() {

    }

    /** Push element x to the back of queue. */
    public void push(int x) {
        dataStack1.push(x);
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        if(!dataStack2.isEmpty()){
            return dataStack2.pop();
        }
        while (!dataStack1.isEmpty()){
            dataStack2.push(dataStack1.pop());
        }
        return dataStack2.pop();
    }

    /** Get the front element. */
    public int peek() {
        if(!dataStack2.isEmpty()){
            return dataStack2.peek();
        }
        while (!dataStack1.isEmpty()){
            dataStack2.push(dataStack1.pop());
        }
        return dataStack2.peek();
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        if(dataStack1.isEmpty() && dataStack2.isEmpty()){
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        MyQueue queue = new MyQueue();
        queue.push(1);
        queue.push(2);
        System.out.println(queue.peek());
        System.out.println(queue.pop());
        System.out.println(queue.empty());
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */
