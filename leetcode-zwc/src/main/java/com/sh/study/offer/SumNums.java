package com.sh.study.offer;

import java.util.stream.IntStream;

/**
 * 剑指 Offer 64. 求1+2+…+n
 * 求 1+2+...+n ，要求不能使用乘除法、for、while、if、else、switch、case等关键字及条件判断语句（A?B:C）。
 *
 *
 *
 * 示例 1：
 *
 * 输入: n = 3
 * 输出: 6
 * 示例 2：
 *
 * 输入: n = 9
 * 输出: 45
 *
 *
 * 限制：
 *
 * 1 <= n <= 10000
 *
 * @author zhouwenchen
 * @date 2021/9/24 9:59
 **/
public class SumNums {
    /**
     * 递归实现的
     * @param n
     * @return
     */
    public static int sumNums(int n) {
        if(n==0){
            return 0;
        }
        return n+ sumNums(n-1);
    }

    /**
     * java8 特性
     * @param n
     * @return
     */
    public static int sumNums1(int n) {
        return IntStream.range(1,n+1).sum();
    }

    /**
     * 等差数列公式的嘛
     * @param n
     * @return
     */
    public static int sumNums2(int n) {
        return n * (n+1) >> 1;
    }
    // 由于 方法  sumNums2 中使用了乘法，所以需要使用位运算实现乘法
    public static int sumNums3(int n) {
        return quickMul(n,n+1) >> 1;
    }
    public static int quickMul(int a,int b){
        int res = 0;
        boolean flag;
        flag = b != 0 &&
                (flag = (b & 1) == 1 &&
                        (res += a + quickMul(a<<=1, b>>=1)) > 0 ||
                        (res += quickMul(a<<=1, b>>=1)) > 0);
        return res;
    }

    int fun(int a,int b){
        int ans = 0;
        boolean flag = (b != 0) && (ans = (a & -(b & 1)) + fun(a << 1, b >> 1)) >= 0;
        return ans ;
    }

    public static void main(String[] args) {
        System.out.println(sumNums3(3));
        System.out.println(sumNums3(9));
    }
}
