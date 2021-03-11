package com.sh.study.stack;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * 逆波兰表达式的生成器
 *  已知计算的的数字表达式是： 4*5-8+60+8/2
 *  可以转化成 二叉树的后缀遍历
 *  形成逆波兰式表达式
 *
 *  4 5 * 8 - 60 + 8 2 / +
 *
 *  这个也就是如何根据生成好的逆波兰式计算数据
 */
public class PolandNotation {

    public static int polandNotation(String expression){
        String[] arr = expression.split(" ");
        List<String> list = Arrays.asList(arr);
        // 创建存放字符串的栈
        Stack<String> stack = new Stack<>();
        list.stream().forEach(data->{
            // 正则判断是否是数字
            if(data.matches("\\d+")){
                stack.push(data);
            } else {
                int num2 = Integer.parseInt(stack.pop());
                int num1 = Integer.parseInt(stack.pop());
                int res = 0;
                // 进行运算
                if(data.equals("+")){
                    res = num1 + num2;
                } else if (data.equals("-")){
                    res = num1 - num2;
                } else if(data.equals("*")){
                    res = num1 * num2;
                } else if(data.equals("/")){
                    res = num1 / num2;
                }
                stack.push("" + res);
            }
        });
        return Integer.parseInt(stack.pop());
    }


    public static void main(String[] args) {
        String expression = "4 5 * 8 - 60 + 8 2 / +";
        System.out.println(polandNotation(expression));
    }
}
