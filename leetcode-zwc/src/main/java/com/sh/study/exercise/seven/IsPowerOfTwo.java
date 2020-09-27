package com.sh.study.exercise.seven;

/**
 * 231. 2的幂
 * 给定一个整数，编写一个函数来判断它是否是 2 的幂次方。
 *
 * 示例 1:
 *
 * 输入: 1
 * 输出: true
 * 解释: 20 = 1
 * 示例 2:
 *
 * 输入: 16
 * 输出: true
 * 解释: 24 = 16
 * 示例 3:
 *
 * 输入: 218
 * 输出: false
 *
 * @Author zhouwenchen
 * @Date  2020-09-25
 **/
public class IsPowerOfTwo {
    public static boolean isPowerOfTwo(int n) {
       if(n<=0){
           return false;
       }
        return (n & (n-1) )== 0;
    }

    public static void main(String[] args) {
        System.out.println(isPowerOfTwo(16));
        System.out.println(isPowerOfTwo(1));

        System.out.println(isPowerOfTwo(218));
        System.out.println(isPowerOfTwo(3));
        System.out.println(isPowerOfTwo(0));
        System.out.println(isPowerOfTwo(-1));
    }
}
