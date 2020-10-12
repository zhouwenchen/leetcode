package com.sh.study.exercise.eight;

import java.util.Map;

/**
 * 300. 最长上升子序列
 * 给定一个无序的整数数组，找到其中最长上升子序列的长度。
 *
 * 示例:
 *
 * 输入: [10,9,2,5,3,7,101,18]
 * 输出: 4
 * 解释: 最长的上升子序列是 [2,3,7,101]，它的长度是 4。
 * 说明:
 *
 * 可能会有多种最长上升子序列的组合，你只需要输出对应的长度即可。
 * 你算法的时间复杂度应该为 O(n2) 。
 * 进阶: 你能将算法的时间复杂度降低到 O(n log n) 吗?
 *
 * @Author zhouwenchen
 * @Date  2020-10-12
 **/
public class LengthOfLIS {
    /**
     * 使用动态规划
     * 思路：
     *  1：dp[i][j]: 表示第 dp[i][j] 个元素  最长上升子序列的长度是
     *  当 i = j 时，dp[i][j] = 1;
     *    i < j 时，if(dp[i][j] > dp[i][j-1] ) dp[i][j] = Math.max(dp[i][j-1] + 1,dp[i-1][j]);
     *             if(dp[i][j] < dp[i][j-1] ) dp[i][j] = Math.max(dp[i][j-1],dp[i-1][j]);
     * @param nums
     * @return
     */
    public static int lengthOfLIS(int[] nums) {
        int m = nums.length;
        int[][] dp = new int[m+1][m+1];
        for (int i = 1; i < m+1; i++){

            for (int j = i;j < m+1; j++){
                if(i == j){
                    dp[i][j] = 1;
                    continue;
                }
                if(nums[i-1] < nums[j-1]){
                    if(nums[j-1] < nums[j-2]){
                        dp[i][j] = Math.max(dp[i][j-1],dp[i-1][j]);
                    }else{
                        dp[i][j] = Math.max(dp[i][j-1]+1,dp[i-1][j]);
                    }
                } else {
                    dp[i][j] = Math.max(dp[i][j-1],dp[i-1][j]);
                }
            }
        }

        return dp[m][m];
    }

    /**
     * 空间优化操作
     *
     * @param nums
     * @return
     */
    public static int lengthOfLIS1(int[] nums) {
        if(nums.length == 0){
            return 0;
        }
        int[] dp = new int[nums.length];
        dp[0] = 1;
        int maxans = 1;
        for (int i = 1; i < nums.length;i++){
            dp[i] = 1;
            for (int j = 0; j < i; j++){
                if(nums[i] > nums[j]){
                    dp[i] = Math.max(dp[i],dp[j] + 1);
                }
            }
            maxans = Math.max(maxans,dp[i]);
        }
        return maxans;
    }

    public static void main(String[] args) {
        int[] nums = {10, 9, 2, 5, 3, 7, 101, 18};
        System.out.println(lengthOfLIS(nums));
    }
}