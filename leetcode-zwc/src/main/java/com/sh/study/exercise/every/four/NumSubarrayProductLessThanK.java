package com.sh.study.exercise.every.four;

/**
 * 713. 乘积小于K的子数组
 * 给定一个正整数数组 nums。
 *
 * 找出该数组内乘积小于 k 的连续的子数组的个数。
 *
 * 示例 1:
 *
 * 输入: nums = [10,5,2,6], k = 100
 * 输出: 8
 * 解释: 8个乘积小于100的子数组分别为: [10], [5], [2], [6], [10,5], [5,2], [2,6], [5,2,6]。
 * 需要注意的是 [10,5,2] 并不是乘积小于100的子数组。
 * 说明:
 *
 * 0 < nums.length <= 50000
 * 0 < nums[i] < 1000
 * 0 <= k < 10^6
 *
 * @author zhouwenchen
 * @date 2021/4/29 11:03
 **/
public class NumSubarrayProductLessThanK {
    /**
     *
     * @param nums
     * @param k
     * @return
     */
    public static int numSubarrayProductLessThanK(int[] nums, int k) {
        final int n = nums == null ? 0 : nums.length;

        int left = -1;
        int ans = 0;
        long sum = 1;

        for (int i = 0; i < n; i++){
            long x = nums[i];
            sum *= x;

            // 如果破坏就 left++
            while (sum >= k && left < i){
                sum /= nums[++left];
            }

            // 此时必然满足
            ans += i - left;

        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(numSubarrayProductLessThanK(new int[]{100, 1, 1, 1, 2, 3, 4}, 6));
    }
}
