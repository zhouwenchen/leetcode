package com.sh.study.exercise.every.three;

import java.util.Stack;

/**
 * 150. 逆波兰表达式求值
 * 根据 逆波兰表示法，求表达式的值。
 *
 * 有效的算符包括 +、-、*、/ 。每个运算对象可以是整数，也可以是另一个逆波兰表达式。
 *
 *
 *
 * 说明：
 *
 * 整数除法只保留整数部分。
 * 给定逆波兰表达式总是有效的。换句话说，表达式总会得出有效数值且不存在除数为 0 的情况。
 *
 *
 * 示例 1：
 *
 * 输入：tokens = ["2","1","+","3","*"]
 * 输出：9
 * 解释：该算式转化为常见的中缀算术表达式为：((2 + 1) * 3) = 9
 * 示例 2：
 *
 * 输入：tokens = ["4","13","5","/","+"]
 * 输出：6
 * 解释：该算式转化为常见的中缀算术表达式为：(4 + (13 / 5)) = 6
 * 示例 3：
 *
 * 输入：tokens = ["10","6","9","3","+","-11","*","/","*","17","+","5","+"]
 * 输出：22
 * 解释：
 * 该算式转化为常见的中缀算术表达式为：
 *   ((10 * (6 / ((9 + 3) * -11))) + 17) + 5
 * = ((10 * (6 / (12 * -11))) + 17) + 5
 * = ((10 * (6 / -132)) + 17) + 5
 * = ((10 * 0) + 17) + 5
 * = (0 + 17) + 5
 * = 17 + 5
 * = 22
 *
 */
public class EvalRPN {

    public static int evalRPN(String[] tokens) {
        int m = tokens.length;
        if(m == 0){
            return 0;
        }
        // data1 数据   data2 存符号
        Stack<Integer> data1 = new Stack();
        for (String token: tokens){
            switch (token){
                case "+":
                    int value = data1.pop() + data1.pop();
                    data1.push(value);
                    break;
                case "-":
                    Integer tmp1 = data1.pop();
                    Integer tmp2 = data1.pop();
                    value = tmp2 - tmp1;
                    data1.push(value);
                    break;
                case "*":
                    value = data1.pop() * data1.pop();
                    data1.push(value);
                    break;
                case "/":
                    tmp1 = data1.pop();
                    tmp2 = data1.pop();
                    value = tmp2 / tmp1;
                    data1.push(value);
                    break;
                default:
                    data1.push(Integer.parseInt(token));
            }
        }
        return data1.pop();
    }

    public static void main(String[] args) {
        System.out.println(evalRPN(new String[]{"2", "1", "+", "3", "*"})); // 9
        System.out.println(evalRPN(new String[]{"4","13","5","/","+"})); //6
        System.out.println(evalRPN(new String[]{"10","6","9","3","+","-11","*","/","*","17","+","5","+"})); //22
    }
}
