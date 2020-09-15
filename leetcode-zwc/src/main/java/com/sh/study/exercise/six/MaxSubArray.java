package com.sh.study.exercise.six;

/**
 * 53. 最大子序和
 * 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 *
 * 示例:
 *
 * 输入: [-2,1,-3,4,-1,2,1,-5,4]
 * 输出: 6
 * 解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
 * 进阶:
 *
 * 如果你已经实现复杂度为 O(n) 的解法，尝试使用更为精妙的分治法求解。
 *
 * @Author zhouwenchen
 * @Date  2020-09-15
 **/
public class MaxSubArray {

    /**
     * @param nums
     * @return
     */
    public static int maxSubArray(int[] nums) {
        int pre = 0;
        int maxAns = 0;
        for (int x : nums){
            pre = Math.max(pre + x,x);
            maxAns = Math.max(pre,maxAns);
        }
        return maxAns;
    }

    /**
     *
     * @param nums
     * @return
     */
    public static int maxSubArray1(int[] nums) {
        int n = nums.length;
        if(n == 0){
            return 0;
        }
        int[] dp = new int[n];
        // 定义状态转移方程式
        dp[0] = nums[0];
        // 遍历，通过状态转移方程式求得dp[i] 的最大子序和
        int max = dp[0];
        for(int i = 1; i < n; i++){
            dp[i] = Math.max(dp[i - 1] + nums[i],nums[i]);
            max = Math.max(dp[i],max);
        }
        return max;
    }

    public static void main(String[] args) {
//        int[] nums = new int[]{-2,1,-3,4,-1,2,1,-5,4};
        int[] nums = new int[]{1};
//        System.out.println(maxSubArray(nums));
        System.out.println(maxSubArray1(nums));
    }
}
