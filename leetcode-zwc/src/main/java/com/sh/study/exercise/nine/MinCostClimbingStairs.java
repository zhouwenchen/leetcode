package com.sh.study.exercise.nine;

/**
 * 746. 使用最小花费爬楼梯
 * 数组的每个索引作为一个阶梯，第 i个阶梯对应着一个非负数的体力花费值 cost[i](索引从0开始)。
 *
 * 每当你爬上一个阶梯你都要花费对应的体力花费值，然后你可以选择继续爬一个阶梯或者爬两个阶梯。
 *
 * 您需要找到达到楼层顶部的最低花费。在开始时，你可以选择从索引为 0 或 1 的元素作为初始阶梯。
 *
 * 示例 1:
 *
 * 输入: cost = [10, 15, 20]
 * 输出: 15
 * 解释: 最低花费是从cost[1]开始，然后走两步即可到阶梯顶，一共花费15。
 *  示例 2:
 *
 * 输入: cost = [1, 100, 1, 1, 1, 100, 1, 1, 100, 1]
 * 输出: 6
 * 解释: 最低花费方式是从cost[0]开始，逐个经过那些1，跳过cost[3]，一共花费6。
 *
 * @Author zhouwenchen
 * @Data 2020/10/27/20
 **/
public class MinCostClimbingStairs {
    /**
     * 动态规划
     *  int[] dp = new int[cost.length];
     * base case：i = 0 时 dp[i] = cost[0];
     *            i = 1 时，dp[i] = cost[1];
     *            i >= 2 时： dp[i] = Math.min(dp[i-1] ,dp[i-2]) + cost[i] ;
     * @param cost
     * @return
     */
    public static int minCostClimbingStairs(int[] cost) {
        if(cost == null){
            return 0;
        }
        if(cost.length == 1){
            return cost[0];
        }
        int min = Math.max(cost[0], cost[1]);
        if(cost.length == 2){
            return min;
        }

        // 大于2
        int[] dp = new int[cost.length];
        dp[0] = cost[0];
        dp[1] = cost[1];
        for (int i = 2; i < cost.length; i++){
            dp[i] = Math.min(dp[i-1] ,dp[i-2]) + cost[i] ;
        }
        return Math.min(dp[cost.length-1], dp[cost.length-2]);
    }

    public static void main(String[] args) {
//        System.out.println(minCostClimbingStairs(new int[]{1, 100, 1, 1, 1, 100, 1, 1, 100, 1}));
        System.out.println(minCostClimbingStairs(new int[]{0,0,0,1}));
    }
}
