package com.sh.study.exercise.weekly.competition220;

/**
 * @author ：zhouwenchen
 * @date ： 2020/12/20 11:12
 */
public class MaxResult {
    /**
     * 动态规划操作
     *
     * @param nums
     * @param k
     * @return
     */
    public static int maxResult(int[] nums, int k) {
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            dp[i] = Math.max(nums[i-1] + nums[])
        }
        return 0;
    }

    public static void main(String[] args) {
        System.out.println(maxResult(new int[]{1, -1, -2, 4, -7, 3}, 2));
    }
}
