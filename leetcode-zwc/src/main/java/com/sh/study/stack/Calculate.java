package com.sh.study.stack;

/**
 * 224. 基本计算器
 * 实现一个基本的计算器来计算一个简单的字符串表达式的值。
 *
 * 字符串表达式可以包含左括号 ( ，右括号 )，加号 + ，减号 -，非负整数和空格  。
 *
 * 示例 1:
 *
 * 输入: "1 + 1"
 * 输出: 2
 * 示例 2:
 *
 * 输入: " 2-1 + 2 "
 * 输出: 3
 * 示例 3:
 *
 * 输入: "(1+(4+5+2)-3)+(6+8)"
 * 输出: 23
 * 说明：
 *
 * 你可以假设所给定的表达式都是有效的。
 * 请不要使用内置的库函数 eval。
 * @Author zhouwenchen
 * @Data 2020/8/10/20
 **/
public class Calculate {

    /**
     * 使用两个栈，一个存放数据，一个存放操作符和左右括号
     * @param s
     * @return
     */
    public static int calculate(String s) {
        String[] arr = s.split("");

        return 0;
    }

    public static void main(String[] args) {
        System.out.println(calculate("2-1+2"));
        System.out.println(calculate("4-(1+2)"));
        System.out.println(calculate("(1+(4+5+2)-3)+(6+8)"));
    }
}
