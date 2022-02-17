package com.sh.study.exercise.every.two;

import java.util.HashMap;
import java.util.Map;

/**
 * 2006. 差的绝对值为 K 的数对数目
 * 给你一个整数数组 nums 和一个整数 k ，请你返回数对 (i, j) 的数目，满足 i < j 且 |nums[i] - nums[j]| == k 。
 *
 * |x| 的值定义为：
 *
 * 如果 x >= 0 ，那么值为 x 。
 * 如果 x < 0 ，那么值为 -x 。
 *
 *
 * 示例 1：
 *
 * 输入：nums = [1,2,2,1], k = 1
 * 输出：4
 * 解释：差的绝对值为 1 的数对为：
 * - [1,2,2,1]
 * - [1,2,2,1]
 * - [1,2,2,1]
 * - [1,2,2,1]
 * 示例 2：
 *
 * 输入：nums = [1,3], k = 3
 * 输出：0
 * 解释：没有任何数对差的绝对值为 3 。
 * 示例 3：
 *
 * 输入：nums = [3,2,1,5,4], k = 2
 * 输出：3
 * 解释：差的绝对值为 2 的数对为：
 * - [3,2,1,5,4]
 * - [3,2,1,5,4]
 * - [3,2,1,5,4]
 *
 *
 * 提示：
 *
 * 1 <= nums.length <= 200
 * 1 <= nums[i] <= 100
 * 1 <= k <= 99
 *
 * @author zhouwenchen
 * @date 2022/2/14 14:55
 **/
public class CountKDifference {

    /**
     * 暴力遍历
     * @param nums
     * @param k
     * @return
     */
    public static int countKDifference(int[] nums, int k) {
        int res = 0;
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            for (int j = i+1; j<n;j++){
                if(Math.abs(nums[i]-nums[j])== k){
                    res++;
                }
            }
        }
        return res;
    }

    public static int countKDifference1(int[] nums, int k) {
        int res = 0,n = nums.length;
        Map<Integer,Integer> cnt = new HashMap<>();
        for (int j = 0; j < n; ++j){
            res+= cnt.getOrDefault(nums[j]-k,0) + cnt.getOrDefault(nums[j]+k,0);
            cnt.put(nums[j],cnt.getOrDefault(nums[j],0)+1);
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(countKDifference(new int[]{3, 2, 1, 5, 4}, 2));
    }
}
