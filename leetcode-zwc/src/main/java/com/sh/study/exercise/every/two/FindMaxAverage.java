package com.sh.study.exercise.every.two;

/**
 * 643. 子数组最大平均数 I
 * 给定 n 个整数，找出平均数最大且长度为 k 的连续子数组，并输出该最大平均数。
 *
 *
 *
 * 示例：
 *
 * 输入：[1,12,-5,-6,50,3], k = 4
 * 输出：12.75
 * 解释：最大平均数 (12-5-6+50)/4 = 51/4 = 12.75
 *
 */
public class FindMaxAverage {

    /**
     * 使用滑动窗口实现的操作
     * @param nums
     * @param k
     * @return
     */
    public static double findMaxAverage(int[] nums, int k) {
        int sum = 0;
        // 先计算k个和
        for (int i = 0; i < k; i++){
            sum += nums[i];
        }

        int maxSum = sum;
        for (int i = k; i < nums.length;i++){
            sum = sum - nums[i-k] + nums[i];
            maxSum = Math.max(maxSum,sum);
        }
        return 1.0 * maxSum/k;
    }

    public static void main(String[] args) {
        int[] nums = {1, 12, -5, -6, 50, 3};
        System.out.println(findMaxAverage(nums, 4));
    }
}
