package com.sh.study.offer;

import java.util.Stack;

/**
 * 剑指 Offer 30. 包含min函数的栈
 * 定义栈的数据结构，请在该类型中实现一个能够得到栈的最小元素的 min 函数在该栈中，调用 min、push 及 pop 的时间复杂度都是 O(1)。
 *
 *
 *
 * 示例:
 *
 * MinStack minStack = new MinStack();
 * minStack.push(-2);
 * minStack.push(0);
 * minStack.push(-3);
 * minStack.min();   --> 返回 -3.
 * minStack.pop();
 * minStack.top();      --> 返回 0.
 * minStack.min();   --> 返回 -2.
 *
 *
 * 提示：
 *
 * 各函数的调用总次数不超过 20000 次
 *
 * @author zhouwenchen
 * @date 2021/9/6 14:09
 **/
public class MinStack {
    /** initialize your data structure here. */
    Stack<Integer> dataStack = new Stack<>();
    Stack<Integer> minStack = new Stack<>();
    public MinStack() {

    }

    /**
     * 入栈操作，先入data栈，判断data入栈的操作数是否小于 min中的栈顶元素，如果是，直接将data数据入栈到min中
     * @param x
     */
    public void push(int x) {
       dataStack.push(x);
       if(minStack.isEmpty() || minStack.peek() > x){
           minStack.push(x);
       }else {
           minStack.push(minStack.peek());
       }
    }

    public void pop() {
        dataStack.pop();
        minStack.pop();
    }

    public int top() {
        return dataStack.peek();
    }

    public int min() {
        return minStack.isEmpty()?-1:minStack.peek();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.min();
 */