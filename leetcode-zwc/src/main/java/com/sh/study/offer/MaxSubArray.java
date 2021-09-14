package com.sh.study.offer;

/**
 * 剑指 Offer 42. 连续子数组的最大和
 * 输入一个整型数组，数组中的一个或连续多个整数组成一个子数组。求所有子数组的和的最大值。
 *
 * 要求时间复杂度为O(n)。
 *
 *
 *
 * 示例1:
 *
 * 输入: nums = [-2,1,-3,4,-1,2,1,-5,4]
 * 输出: 6
 * 解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
 *
 *
 * 提示：
 *
 * 1 <= arr.length <= 10^5
 * -100 <= arr[i] <= 100
 * 注意：本题与主站 53 题相同：https://leetcode-cn.com/problems/maximum-subarray/
 *
 * @author zhouwenchen
 * @date 2021/9/14 14:00
 **/
public class MaxSubArray {
    /**
     * 动态规划操作
     * @param nums
     * @return
     */
    public static int maxSubArray(int[] nums) {
        int n = nums.length;
        if(n == 0){
            return 0;
        }
        int[] dp = new int[n];
        dp[0] = nums[0];
        int max = dp[0];
        for (int i = 1; i < n; i++){
            dp[i] = Math.max(dp[i-1] + nums[i],nums[i]);
            max = Math.max(dp[i],max);
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(maxSubArray(new int[]{-2,1,-3,4,-1,2,1,-5,4}));
    }
}
