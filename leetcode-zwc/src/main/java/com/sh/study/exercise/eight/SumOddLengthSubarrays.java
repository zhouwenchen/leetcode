package com.sh.study.exercise.eight;

/**
 * 1588. 所有奇数长度子数组的和
 * 给你一个正整数数组 arr ，请你计算所有可能的奇数长度子数组的和。
 *
 * 子数组 定义为原数组中的一个连续子序列。
 *
 * 请你返回 arr 中 所有奇数长度子数组的和 。
 *
 *
 *
 * 示例 1：
 *
 * 输入：arr = [1,4,2,5,3]
 * 输出：58
 * 解释：所有奇数长度子数组和它们的和为：
 * [1] = 1
 * [4] = 4
 * [2] = 2
 * [5] = 5
 * [3] = 3
 * [1,4,2] = 7
 * [4,2,5] = 11
 * [2,5,3] = 10
 * [1,4,2,5,3] = 15
 * 我们将所有值求和得到 1 + 4 + 2 + 5 + 3 + 7 + 11 + 10 + 15 = 58
 * 示例 2：
 *
 * 输入：arr = [1,2]
 * 输出：3
 * 解释：总共只有 2 个长度为奇数的子数组，[1] 和 [2]。它们的和为 3 。
 * 示例 3：
 *
 * 输入：arr = [10,11,12]
 * 输出：66
 *
 * @author zhouwenchen
 * @date 2021/8/30 9:24
 **/
public class SumOddLengthSubarrays {

    /**
     * 使用三层for循环直接遍历出结果,性能比较差
     *
     * @param arr
     * @return
     */
    public static int sumOddLengthSubarrays(int[] arr) {
        int sum = 0;
        int n = arr.length;
        // 第一层循环
        for (int start = 0; start < n; start++){
            // 第二层循环
            for (int len = 1; start + len <= n; len += 2){
                int end = start + len -1;
                for (int i = start; i <= end;i++){
                    sum+= arr[i];
                }
            }
        }
        return sum;
    }

    /**
     * 前缀和
     * https://leetcode-cn.com/problems/sum-of-all-odd-length-subarrays/solution/suo-you-qi-shu-chang-du-zi-shu-zu-de-he-yoaqu/
     *
     * @param arr
     * @return
     */
    public static int sumOddLengthSubarrays1(int[] arr) {
        int n = arr.length;
        int[] prefixSum = new int[n+1];
        for (int i = 0; i < n; i++){
            prefixSum[i+1] = prefixSum[i] + arr[i];
        }

        int sum = 0;
        for (int start = 0; start < n; start++){
            for (int len = 1; start + len <= n; len += 2){
                int end = start + len -1;
                sum += prefixSum[end + 1] - prefixSum[start];
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1,4,2,5,3};
        System.out.println(sumOddLengthSubarrays(arr));
        System.out.println(sumOddLengthSubarrays1(arr));
    }

}
