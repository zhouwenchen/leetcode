package com.leetcode.lxj.day0819;

import java.util.Stack;

/**
 * 请设计一个栈，除了常规栈支持的pop与push函数以外，还支持min函数，该函数返回栈元素中的最小值。执行push、pop和min操作的时间复杂度必须为O(1)。
 *
 *
 * 示例：
 *
 * MinStack minStack = new MinStack();
 * minStack.push(-2);
 * minStack.push(0);
 * minStack.push(-3);
 * minStack.getMin();   --> 返回 -3.
 * minStack.pop();
 * minStack.top();      --> 返回 0.
 * minStack.getMin();   --> 返回 -2.
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/min-stack-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class MinStack {
    Stack<Integer> stack;
    Stack<Integer> mMinStack;
    /** initialize your data structure here. */
    public MinStack() {
        stack = new Stack<>();
        mMinStack = new Stack<>();
    }
    
    public void push(int x) {
        stack.push(x);
        if (mMinStack.empty()) {
            mMinStack.push(x);
        } else {
            if (x <= mMinStack.peek()) {
                mMinStack.push(x);
            }
        }
    }
    
    public void pop() {
        int top = stack.pop();
        if (top == mMinStack.peek()) {
            mMinStack.pop();
        }
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int getMin() {
        return mMinStack.empty() ? 0 : mMinStack.peek();
    }

    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(2);
        minStack.push(0);
        minStack.push(3);
        minStack.push(0);
        System.out.println(minStack.getMin());
        minStack.pop();
        System.out.println(minStack.top());
        System.out.println(minStack.getMin());
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */