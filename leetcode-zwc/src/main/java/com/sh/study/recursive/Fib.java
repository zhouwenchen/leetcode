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

    /**
     * 基于递归，使用备忘录实现
     * @param n
     * @return
     */
    public static int[] arr = new int[71];
    public static int fib3(int n){
        if(n==1 || n==2){
            return 1;
        }
        if(arr[n] !=0){
            return arr[n];
        }
        arr[n] = fib3(n-1) + fib3(n-2);
        return arr[n];
    }

    /**
     * 基于动态规划
     * int[] dp = new int[n];
     * 当 i = 1,2时，dp[1] =1,dp[2] = 1;
     * 当 i>2时，dp[i] = dp[i-1]+ dp[i-2];
     * @param n
     * @return
     */
    public static int fib4(int n){
        // base case
        int[] dp = new int[n+1];
        dp[1] = 1;
        dp[2] = 1;
        for (int i = 3; i <=n;i++){
            // 状态转移方程式
            dp[i] = dp[i-1]+dp[i-2];
        }
        return dp[n];
    }

    /**
     *509. 斐波那契数
     * 斐波那契数，通常用 F(n) 表示，形成的序列称为 斐波那契数列 。该数列由 0 和 1 开始，后面的每一项数字都是前面两项数字的和。也就是：
     *
     * F(0) = 0，F(1) = 1
     * F(n) = F(n - 1) + F(n - 2)，其中 n > 1
     * 给你 n ，请计算 F(n) 。
     *
     *
     *
     * 示例 1：
     *
     * 输入：2
     * 输出：1
     * 解释：F(2) = F(1) + F(0) = 1 + 0 = 1
     * 示例 2：
     *
     * 输入：3
     * 输出：2
     * 解释：F(3) = F(2) + F(1) = 1 + 1 = 2
     * 示例 3：
     *
     * 输入：4
     * 输出：3
     * 解释：F(4) = F(3) + F(2) = 2 + 1 = 3
     * https://leetcode-cn.com/problems/fibonacci-number/
     * @date 20210104
     * @param n
     */
    public static int fib5(int n){
        int[] dp = new int[n+1];
        if(n == 0){
           return 0;
        }
        if(n == 1 || n == 2){
            return 1;
        }
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 1;
        for (int i = 3; i <= n; i++){
            dp[i] = dp[i-1] + dp[i-2];
        }
        return dp[n];
    }

    public static void main(String[] args) {
        System.out.println(fib1(20));
        System.out.println(fib2(20));
        System.out.println(fib3(20));
        System.out.println(fib4(20));
        System.out.println(fib5(3));
    }
}
