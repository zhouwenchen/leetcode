package com.sh.study.offer;

/**
 * 剑指 Offer 65. 不用加减乘除做加法
 * 写一个函数，求两个整数之和，要求在函数体内不得使用 “+”、“-”、“*”、“/” 四则运算符号。
 *
 *
 *
 * 示例:
 *
 * 输入: a = 1, b = 1
 * 输出: 2
 *
 *
 * 提示：
 *
 * a, b 均可能是负数或 0
 * 结果不会溢出 32 位整数
 * @author zhouwenchen
 * @date 2021/9/26 10:41
 **/
public class Add {
    /**
     * 无进位和 与 异或运算 规律相同，进位 和 与运算 规律相同（并需左移一位）
     *
     * @param a
     * @param b
     * @return
     */
    public static int add(int a, int b) {
        while (b != 0){
            int carry = (a&b) << 1;
            a ^= b;
            b = carry;
        }
        return a;
    }

    public static void main(String[] args) {
        System.out.println(add(1, 2));
    }
}
