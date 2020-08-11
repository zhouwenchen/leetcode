package com.sh.study.recursive;

import java.util.HashMap;

/**
 * 编程实现斐波那契数列求值f(n)=f(n-1)+f(n-2)
 * 剑指 Offer 10- I. 斐波那契数列
 *
 * 写一个函数，输入 n ，求斐波那契（Fibonacci）数列的第 n 项。斐波那契数列的定义如下：
 *
 * F(0) = 0,   F(1) = 1
 * F(N) = F(N - 1) + F(N - 2), 其中 N > 1.
 * 斐波那契数列由 0 和 1 开始，之后的斐波那契数就是由之前的两数相加而得出。
 *
 * 答案需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1。
 *
 *
 *
 * 示例 1：
 *
 * 输入：n = 2
 * 输出：1
 * 示例 2：
 *
 * 输入：n = 5
 * 输出：5
 *
 *
 * 提示：
 *
 * 0 <= n <= 100
 * @Author zhouwenchen
 * @Data 2020/8/11/15
 **/
public class Fib {

    private static int constant = 1000000007;
    /**
     * 这种方式是不可以的，会超时，栈内存也容易溢出的
     * @param n
     * @return
     */
    public static int fib(int n) {
        if(n == 0){
            return 0;
        }
        if(n == 1){
            return 1;
        }
        return fib(n-1) + fib(n -2);
    }

    public static int fib1(int n){
        return fib1(n,new HashMap<Integer,Integer>());
    }

    private static int fib1(int n, HashMap<Integer,Integer> map) {
        if(n < 2){
            return n;
        }
        // 判断map中是否存在对应的中间值
        if(map.containsKey(n)){
            return map.get(n);
        }
        int first = fib1(n-1,map) % constant;
        map.put(n -1, first);

        int secode = fib1(n-2,map) % constant;
        map.put(n -2, secode);
        int sum = (first + secode)% constant;
        map.put(n, sum);
        return sum;
    }

    /**
     * 转换成循环操作
     * @param n
     * @return
     */
    public static int fib2(int n){
        int a = 0;
        int b = 1;
        int sum = 0;
        for(int i = 0; i < n; i++){
            sum = (a + b) % 1000000007;
            a = b;
            b = sum;
        }
        return a;
    }

    public static void main(String[] args) {
        System.out.println(fib1(70));
        System.out.println(fib2(70));
    }
}
