package com.sh.study.exercise.four;

/**
 * 122. 买卖股票的最佳时机 II
 * 给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
 *
 * 设计一个算法来计算你所能获取的最大利润。你可以尽可能地完成更多的交易（多次买卖一支股票）。
 *
 * 注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
 *
 *
 *
 * 示例 1:
 *
 * 输入: [7,1,5,3,6,4]
 * 输出: 7
 * 解释: 在第 2 天（股票价格 = 1）的时候买入，在第 3 天（股票价格 = 5）的时候卖出, 这笔交易所能获得利润 = 5-1 = 4 。
 *      随后，在第 4 天（股票价格 = 3）的时候买入，在第 5 天（股票价格 = 6）的时候卖出, 这笔交易所能获得利润 = 6-3 = 3 。
 * 示例 2:
 *
 * 输入: [1,2,3,4,5]
 * 输出: 4
 * 解释: 在第 1 天（股票价格 = 1）的时候买入，在第 5 天 （股票价格 = 5）的时候卖出, 这笔交易所能获得利润 = 5-1 = 4 。
 *      注意你不能在第 1 天和第 2 天接连购买股票，之后再将它们卖出。
 *      因为这样属于同时参与了多笔交易，你必须在再次购买前出售掉之前的股票。
 * 示例 3:
 *
 * 输入: [7,6,4,3,1]
 * 输出: 0
 * 解释: 在这种情况下, 没有交易完成, 所以最大利润为 0。
 *
 * TODO https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-ii/solution/mai-mai-gu-piao-de-zui-jia-shi-ji-ii-by-leetcode/
 * 官方解答
 *
 * @Author zhouwenchen
 * @Data 2020/8/26/11
 **/
public class MaxProfit1 {

    /**
     *  一次遍历实现操作 递归实现操作
     *
     * @param prices
     * @return
     */
    public static int maxProfit(int[] prices) {
        return calculate(prices,0);
    }

    private static int calculate(int[] prices, int s) {
        if(s >= prices.length){
            return 0;
        }
        int max = 0;
        for(int start = s; start < prices.length;start++){
            int maxProit = 0;
            for(int i = start + 1; i < prices.length;i++){
                int profit = calculate(prices, i+1) + prices[i] - prices[start];
                if(profit > maxProit){
                    maxProit = profit;
                }
            }
            if(maxProit > max){
                max= maxProit;
            }
        }
        return max;
    }

    /**
     * 类似于折线图，找到第一个最小值，找到第一个最大值，然后取其间隔数据
     *
     * @param prices
     * @return
     */
    public static int maxProfit1(int[] prices){
        int i = 0;
        int valley = prices[0];
        int peak = prices[0];
        int max = 0;
        while (i <prices.length -1){
            while (i < prices.length -1 && prices[i] >= prices[i+1]){
                i++;
            }
            valley = prices[i];

            while (i < prices.length -1 && prices[i] <= prices[i+1]){
                i++;
            }
            peak = prices[i];
            max += peak - valley;
        }
        return max;
    }

    /**
     *
     * @return
     */
    public static int maxProfit2(int[] prices){
        int maxProit = 0;
        for(int i = 1; i < prices.length;i++){
            if(prices[i] > prices[i-1]){
                maxProit += prices[i] - prices[i-1];
            }
        }
        return maxProit;
    }

    /**
     * 123. 买卖股票的最佳时机 III
     * 给定一个数组，它的第 i 个元素是一支给定的股票在第 i 天的价格。
     *
     * 设计一个算法来计算你所能获取的最大利润。你最多可以完成 两笔 交易。
     *
     * 注意: 你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
     *
     * 示例 1:
     *
     * 输入: [3,3,5,0,0,3,1,4]
     * 输出: 6
     * 解释: 在第 4 天（股票价格 = 0）的时候买入，在第 6 天（股票价格 = 3）的时候卖出，这笔交易所能获得利润 = 3-0 = 3 。
     *      随后，在第 7 天（股票价格 = 1）的时候买入，在第 8 天 （股票价格 = 4）的时候卖出，这笔交易所能获得利润 = 4-1 = 3 。
     * 示例 2:
     *
     * 输入: [1,2,3,4,5]
     * 输出: 4
     * 解释: 在第 1 天（股票价格 = 1）的时候买入，在第 5 天 （股票价格 = 5）的时候卖出, 这笔交易所能获得利润 = 5-1 = 4 。
     *      注意你不能在第 1 天和第 2 天接连购买股票，之后再将它们卖出。
     *      因为这样属于同时参与了多笔交易，你必须在再次购买前出售掉之前的股票。
     * 示例 3:
     *
     * 输入: [7,6,4,3,1]
     * 输出: 0
     * 解释: 在这个情况下, 没有交易完成, 所以最大利润为 0。
     *
     * @param prices
     * @return
     */
    public int maxProfit3(int[] prices) {
        int n = prices.length;
        if(n <= 1){
            return 0;
        }
        // 5个状态,0-4分别表示：  未交易，买入一次，完成交易1次，买入两次，完成交易2次
        int[] dp = new int[5];
        dp[0] = 0;
        dp[1] = - prices[0];
        dp[2] = Integer.MIN_VALUE;
        dp[3] = Integer.MIN_VALUE;
        dp[4] = Integer.MIN_VALUE;

        for (int i = 1; i < n;i++){
            dp[0] = 0;
            dp[1] = Math.max(dp[1],dp[0] - prices[i]);
            dp[2] = Math.max(dp[2], dp[1] + prices[i]);
            dp[3] = Math.max(dp[3], dp[2] - prices[i]);
            dp[4] = Math.max(dp[4], dp[3] + prices[i]);

        }
        return Math.max(dp[2], dp[4]);
    }

    public static void main(String[] args) {
        int[] nums = new int[]{7,1,5,3,6,4};    // 7
//        int[] nums = new int[]{1,2,3,4,5};    // 4
//        int[] nums = new int[]{7,6,4,3,1};    // 0
        System.out.println(maxProfit2(nums));
    }
}
