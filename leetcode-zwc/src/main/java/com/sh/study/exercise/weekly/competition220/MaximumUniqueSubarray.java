package com.sh.study.exercise.weekly.competition220;

import java.util.*;

/**
 *
 * 5630. 删除子数组的最大得分
 *
 * 给你一个正整数数组 nums ，请你从中删除一个含有 若干不同元素 的子数组。删除子数组的 得分 就是子数组各元素之 和 。
 *
 * 返回 只删除一个 子数组可获得的 最大得分 。
 *
 * 如果数组 b 是数组 a 的一个连续子序列，即如果它等于 a[l],a[l+1],...,a[r] ，那么它就是 a 的一个子数组。
 *
 *
 *
 * 示例 1：
 *
 * 输入：nums = [4,2,4,5,6]
 * 输出：17
 * 解释：最优子数组是 [2,4,5,6]
 * 示例 2：
 *
 * 输入：nums = [5,2,1,2,5,2,1,2,5]
 * 输出：8
 * 解释：最优子数组是 [5,2,1] 或 [1,2,5]
 *
 *
 * 提示：
 *
 * 1 <= nums.length <= 105
 * 1 <= nums[i] <= 104
 * @author ：zhouwenchen
 * @date ： 2020/12/20 11:09
 */
public class MaximumUniqueSubarray {
    /**
     * 使用 set 操作
     * @param nums
     * @return
     */
    public static int maximumUniqueSubarray(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int max = 0,sum = 0,start =0;
        for (int i = 0; i < nums.length;i++){
            if(!set.contains(nums[i])){
                set.add(nums[i]);
                sum += nums[i];
                max = Math.max(sum,max);
            } else {
                while (nums[i]  != nums[start]){
                    sum -= nums[start];
                    set.remove(nums[start]);
                    start++;
                }
                start++;
            }
        }
        return max;
    }

    /**
     * 滑动窗口
     * @param nums
     * @return
     */
    public static int maximumUniqueSubarray1(int[] nums) {
        // 创建窗口
        Map<Integer,Integer> window = new HashMap<>();
        int left = 0, right = 0;
        int res = 0, cur = 0;
        while (right < nums.length){
            // 向右扩张
            int k = nums[right++];
            window.put(k,window.getOrDefault(k,0) + 1);
            cur += k;

            // 3判断是否需要左侧收缩
            while (window.get(k) > 1){
                int d = nums[left++];
                window.put(d,window.get(d)-1);
                cur -= d;
            }
            res = Math.max(res,cur);
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(maximumUniqueSubarray(new int[]{4, 2, 4, 5, 6}));
        System.out.println(maximumUniqueSubarray(new int[]{5,2,1,2,5,2,1,2,5}));
        System.out.println(maximumUniqueSubarray1(new int[]{4, 2, 4, 5, 6}));
        System.out.println(maximumUniqueSubarray1(new int[]{5,2,1,2,5,2,1,2,5}));
    }
}
