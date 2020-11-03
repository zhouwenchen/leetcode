package com.sh.study.exercise.nine;

/**
 * 70. 爬楼梯
 * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
 *
 * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 *
 * 注意：给定 n 是一个正整数。
 *
 * 示例 1：
 *
 * 输入： 2
 * 输出： 2
 * 解释： 有两种方法可以爬到楼顶。
 * 1.  1 阶 + 1 阶
 * 2.  2 阶
 * 示例 2：
 *
 * 输入： 3
 * 输出： 3
 * 解释： 有三种方法可以爬到楼顶。
 * 1.  1 阶 + 1 阶 + 1 阶
 * 2.  1 阶 + 2 阶
 * 3.  2 阶 + 1 阶
 *
 * @Author zhouwenchen
 * @Data 2020/10/28/10
 **/
public class ClimbStairs {

    /**
     * 思考： 1 1
     *       2 2
     *       3 3
     *       4 5
     * 感觉和斐波那契一样呀
     * @param n
     * @return
     */
    public static int climbStairs(int n) {
        if(n == 1){
            return 1;
        }
        if(n == 2){
            return 2;
        }
        int[] dp = new int[n];
        dp[0] = 1;
        dp[1] = 2;
        for (int i = 2; i < n; i++){
            dp[i] = dp[i-1] + dp[i-2];
        }
        return dp[n-1];
    }

    /**
     * 空间复杂度的优化
     * @param n
     * @return
     */
    public static int climbStairs1(int n) {
        if(n == 1){
            return 1;
        }
        if(n == 2){
            return 2;
        }
        int[] dp = new int[2];
        dp[0] = 1;
        dp[1] = 2;
        for (int i = 2; i < n; i++){
            int temp = dp[1];
            dp[1] = dp[0] + dp[1];
            dp[0] = temp;
        }
        return dp[1];
    }

    public static void main(String[] args) {
        System.out.println(climbStairs1(5));
    }
}
