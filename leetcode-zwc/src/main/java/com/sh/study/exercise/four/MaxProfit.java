package com.sh.study.exercise.four;

/**
 * 121. 买卖股票的最佳时机
 * 给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
 *
 * 如果你最多只允许完成一笔交易（即买入和卖出一支股票一次），设计一个算法来计算你所能获取的最大利润。
 *
 * 注意：你不能在买入股票前卖出股票。
 *
 * 示例 1:
 *
 * 输入: [7,1,5,3,6,4]
 * 输出: 5
 * 解释: 在第 2 天（股票价格 = 1）的时候买入，在第 5 天（股票价格 = 6）的时候卖出，最大利润 = 6-1 = 5 。
 *      注意利润不能是 7-1 = 6, 因为卖出价格需要大于买入价格；同时，你不能在买入前卖出股票。
 * 示例 2:
 *
 * 输入: [7,6,4,3,1]
 * 输出: 0
 * 解释: 在这种情况下, 没有交易完成, 所以最大利润为 0。
 *
 * @Author zhouwenchen
 * @Data 2020/8/26/11
 **/
public class MaxProfit {

    /**
     * 两次遍历
     * @param prices
     * @return
     */
    public static int maxProfit(int[] prices) {
        int maxProfit = 0;
        for(int i = 0; i < prices.length - 1; i++){
            for(int j = i+1; j < prices.length; j++){
                int profit = prices[j] - prices[i];
                if(profit > maxProfit){
                    maxProfit = profit;
                }
            }
        }
       return maxProfit;
    }

    /**
     *  一次遍历实现操作
     * @param prices
     * @return
     */
    public static int maxProfit1(int[] prices) {
        if (prices == null) {
            return 0;
        }
        int maxProfit = 0;
        int min = prices[0];
        for (int i = 0; i < prices.length; i++) {
            if (min < prices[i]) {
                maxProfit = (prices[i] - min) > maxProfit ? prices[i] - min : maxProfit;
            } else {
                min = prices[i];
            }
        }
        return maxProfit;
    }


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
     * @param prices
     * @return
     */
    public static int maxProfit2(int[] prices) {
        int maxprofit = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1]) {
                maxprofit += prices[i] - prices[i - 1];
            }
        }
        return maxprofit;
    }

    /**
     * 714. 买卖股票的最佳时机含手续费
     * 给定一个整数数组 prices，其中第 i 个元素代表了第 i 天的股票价格 ；非负整数 fee 代表了交易股票的手续费用。
     *
     * 你可以无限次地完成交易，但是你每笔交易都需要付手续费。如果你已经购买了一个股票，在卖出它之前你就不能再继续购买股票了。
     *
     * 返回获得利润的最大值。
     *
     * 注意：这里的一笔交易指买入持有并卖出股票的整个过程，每笔交易你只需要为支付一次手续费。
     *
     * 示例 1:
     *
     * 输入: prices = [1, 3, 2, 8, 4, 9], fee = 2
     * 输出: 8
     * 解释: 能够达到的最大利润:
     * 在此处买入 prices[0] = 1
     * 在此处卖出 prices[3] = 8
     * 在此处买入 prices[4] = 4
     * 在此处卖出 prices[5] = 9
     * 总利润: ((8 - 1) - 2) + ((9 - 4) - 2) = 8.
     * 注意:
     *
     * 0 < prices.length <= 50000.
     * 0 < prices[i] < 50000.
     * 0 <= fee < 50000.
     * 使用动态转移方程式
     * @link https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-with-transaction-fee/solution/mai-mai-gu-piao-de-zui-jia-shi-ji-han-sh-rzlz/
     * int[][] dp = new int[n][2]
     * dp[i][0] 表示第i天交易完成之后手中没有股票的最大利润
     * dp[i][1] 表示第i天交易完成之后手中有一个股票的最大利润
     *
     *  那么  dp[i][0] 表示第 i天交易完成之后手中没有股票，那么可能就是前一天已经没有股票，或者前一天有股票，但是卖了（此时需要手续费）
     *       dp[i][1] 表示第 i天交易完成之后手中有一个股票，那么可能是前一天有股票，或者 此时购买了一个股票（price[i]）
     *
     * @param prices
     * @param fee
     * @return
     */
    public static int maxProfit(int[] prices, int fee) {
        int n = prices.length;
        int[][] dp = new int[n][2];
        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        for (int i = 1; i < n;i++){
            dp[i][0] = Math.max(dp[i-1][0],dp[i-1][1]+prices[i]-fee);
            dp[i][1] = Math.max(dp[i-1][1],dp[i-1][0]-prices[i]);
        }
       return dp[n-1][0];
    }

    public static void main(String[] args) {
//        int[] nums = new int[]{7,1,5,3,6,4};
//        int[] nums = new int[]{7,1,9,3,6,4};
//        int[] nums = new int[]{7,6,4,3,1};
//        int[] nums = new int[]{2,4,1};
//        int[] nums = new int[]{1,2,3,0,2};
//        System.out.println(maxProfit1(nums));

//        System.out.println(maxProfit1(new int[]{7, 1, 5, 3, 6, 4}));
//        System.out.println(maxProfit(new int[]{1, 3, 2, 8, 4, 9},2));
        System.out.println(maxProfit(new int[]{1,3,5,8,2,9},2));
    }
}
