package com.sh.study.stack;

import java.lang.reflect.Array;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

/**
 * 224. 基本计算器
 * 实现一个基本的计算器来计算一个简单的字符串表达式的值。
 * <p>
 * 字符串表达式可以包含左括号 ( ，右括号 )，加号 + ，减号 -，非负整数和空格  。
 * <p>
 * 示例 1:
 * <p>
 * 输入: "1 + 1"
 * 输出: 2
 * 示例 2:
 * <p>
 * 输入: " 2-1 + 2 "
 * 输出: 3
 * 示例 3:
 * <p>
 * 输入: "(1+(4+5+2)-3)+(6+8)"
 * 输出: 23
 * 说明：
 * <p>
 * 你可以假设所给定的表达式都是有效的。
 * 请不要使用内置的库函数 eval。
 *
 * @Author zhouwenchen
 * @Data 2020/8/10/20
 **/
public class Calculate {

    private static final Character plus = '+';
    private static final Character minus = '-';
    private static final Character left = '(';
    private static final Character right = ')';

    /**
     * 使用两个栈，一个datastack1 存放数据，一个存放操作符 datastack2和左右括号
     * TODO 以下的解法只能是个位数的操作，超过两位数就不可行了
     *
     * @param s
     * @return
     */
    public static int calculate(String s) {
        char[] arr = s.toCharArray();
        // 存储数据
        Deque<Integer> stack1 = new ArrayDeque<>();
        // 存储符号
        Deque<Character> stack2 = new ArrayDeque<>();
        boolean flag = false;
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] == ' '){
                flag = false;
                continue;
            }
            if (arr[i] == ')') {
                if(stack2.peek() == left){
                    stack2.pop();
                }
            } else if (arr[i] == '(' || arr[i] == '-' || arr[i] == '+') {
                stack2.push(arr[i]);
                // 如果此时 stack2 不为空 且不能是 '(' ，且 为“+” 或者 “-”，出栈运算
            } else if (!stack2.isEmpty() && stack2.peek() != left) {
                // TODO 这个是有问题的，有可能是连续的数字
                int currentValue = Integer.parseInt(String.valueOf(arr[i]));
                if(i+1 < arr.length && Character.isDigit(arr[i+1])){
                    currentValue = currentValue * 10 +Integer.parseInt(String.valueOf(arr[i++]));
                }
                if (stack2.peek() == plus) {
                    int value = currentValue + stack1.pop();
                    stack2.pop();
                    stack1.push(value);
                } else {
                    int tmp = stack1.isEmpty() ? 0 : stack1.pop();
                    int value = tmp - currentValue;
                    stack2.pop();
                    stack1.push(value);
                }
            } else {
                // TODO 需要判断是否是连续的数字,如果 flag = true 的话，需要取出stack1 中的数据 * 10 + 新进入的数据
                int currentValue = Integer.parseInt(String.valueOf(arr[i]));
                if(flag){
                    Integer value = stack1.pop() * 10 +currentValue;
                    stack1.push(value);
                } else {
                    stack1.push(currentValue);
                }
                flag = true;
                continue;
            }
            flag = false;
        }
        while (!stack1.isEmpty() && !stack2.isEmpty()){
            if(stack2.peek() == left){
                stack2.pop();
                continue;
            }
            if (stack2.peek() == plus) {
                int value = stack1.pop() + stack1.pop();
                stack2.pop();
                stack1.push(value);
            } else if(stack2.peek() == minus) {
                int tmp1 = stack1.pop();
                int tmp2 = stack1.isEmpty()?0:stack1.pop();
                int value = tmp2 - tmp1;
                stack2.pop();
                stack1.push(value);
            }
        }
        return stack1.isEmpty() ? 0 : stack1.pop();
    }

    /**
     * 官方题解
     * 224. 基本计算器
     *
     * @param s
     * @return
     */
    public static int calculate1(String s) {
        Deque<Integer> ops = new ArrayDeque<>();
        ops.push(1);
        int sign = 1;
        int ret =0;
        int n = s.length();
        int i = 0;
        while ( i < n){
            if(s.charAt(i) == ' '){
                i++;
            } else if(s.charAt(i) == plus){
                sign = ops.peek();
                i++;
            } else if(s.charAt(i) == minus){
                sign = -ops.peek();
                i++;
            }else if(s.charAt(i) == left){
                ops.push(sign);
                i++;
            }else if(s.charAt(i) == right){
                ops.pop();
                i++;
            }else {
                long num = 0;
                while (i < n && Character.isDigit(s.charAt(i))){
                    num = num * 10 + s.charAt(i) - '0';
                    i++;
                }
                ret += sign * num;
            }
        }
        return ret;
    }

    /**
     * 227. 基本计算器 II
     * 给你一个字符串表达式 s ，请你实现一个基本计算器来计算并返回它的值。
     *
     * 整数除法仅保留整数部分。
     *
     *
     *
     * 示例 1：
     *
     * 输入：s = "3+2*2"
     * 输出：7
     * 示例 2：
     *
     * 输入：s = " 3/2 "
     * 输出：1
     * 示例 3：
     *
     * 输入：s = " 3+5 / 2 "
     * 输出：5
     *
     * 思路：
     *
     *
     * @param
     */
    public static int calculate2(String s) {
        Deque<Integer> stack = new LinkedList<>();
        char preSign = '+';
        int num = 0;
        int n = s.length();
        for (int i = 0; i < n; i++) {
            if(Character.isDigit(s.charAt(i))){
                num = num * 10 + s.charAt(i) - '0';
            }
            if(!Character.isDigit(s.charAt(i)) && s.charAt(i) != ' ' || i == n-1){
                switch (preSign){
                    case '+':
                        stack.push(num);
                        break;
                    case '-':
                        stack.push(-num);
                        break;
                    case '*':
                        stack.push(num * stack.pop());
                        break;
                    case '/':
                        stack.push(stack.pop()/num);
                        break;
                }
                preSign = s.charAt(i);
                num = 0;
            }
        }
        int ans = 0;
        while (!stack.isEmpty()){
            ans += stack.pop();
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(calculate1("2-1+2"));
        System.out.println(calculate1("4-(1+2)"));
        System.out.println(calculate1("(1+(4+5+2)-3)+(6+8)"));
        System.out.println(calculate1("1 + 1"));
        System.out.println(calculate1("11+11"));
        System.out.println(calculate1("12 - 11"));
        System.out.println(calculate1("-2-1"));
        System.out.println(calculate1("- (3 + (4 + 5))"));

        System.out.println();
    }
}
