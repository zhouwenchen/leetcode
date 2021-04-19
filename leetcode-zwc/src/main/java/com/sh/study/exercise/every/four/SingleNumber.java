package com.sh.study.exercise.every.four;

import java.util.Arrays;

/**
 * 136. 只出现一次的数字
 * 给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
 *
 * 说明：
 *
 * 你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？
 *
 * 示例 1:
 *
 * 输入: [2,2,1]
 * 输出: 1
 * 示例 2:
 *
 * 输入: [4,1,2,1,2]
 * 输出: 4
 *
 * @author zhouwenchen
 * @date 2021/4/16 15:38
 **/
public class SingleNumber {
    public static int singleNumber(int[] nums) {
        if(nums.length == 1){
            return nums[0];
        }
        int result = nums[0];
        for (int i = 1; i < nums.length; i++){
            result = result ^ nums[i];
        }
        return result;
    }

    /**
     * 先排序，判断相邻的元素是否相等，如果相等，跳过，不相等，直接返回
     * @param nums
     * @return
     */
    public static int singleNumber1(int[] nums) {
        if(nums.length == 1){
            return nums[0];
        }
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 1; i+=2) {
            if(nums[i] != nums[i+1]){
                return nums[i];
            }
        }
        return nums[nums.length-1];
    }

    /**
     * 137. 只出现一次的数字 II
     * 给你一个整数数组 nums ，除某个元素仅出现 一次 外，其余每个元素都恰出现 三次 。请你找出并返回那个只出现了一次的元素。
     *
     *
     *
     * 示例 1：
     *
     * 输入：nums = [2,2,3,2]
     * 输出：3
     * 示例 2：
     *
     * 输入：nums = [0,1,0,1,0,1,99]
     * 输出：99
     *
     *  提示：
     *
     * 1 <= nums.length <= 3 * 104
     * -231 <= nums[i] <= 231 - 1
     * nums 中，除某个元素仅出现 一次 外，其余每个元素都恰出现 三次
     *  
     *
     * 进阶：你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？
     *
     * 一种比较简单的思路，就是统计每个每个元素出现的次数，但是要求算法应该具有线性时间复杂度，不适用额外的空间来实现，也就是说不能额外的空间来统计元素出现的次数
     *
     * @param nums
     * @return
     */
    public static int singleNumber2(int[] nums){
        int seenOnce = 0, seenTwice = 0;

        for (int num : nums) {
            // first appearence:
            // add num to seen_once
            // don't add to seen_twice because of presence in seen_once

            // second appearance:
            // remove num from seen_once
            // add num to seen_twice

            // third appearance:
            // don't add to seen_once because of presence in seen_twice
            // remove num from seen_twice
            seenOnce = ~seenTwice & (seenOnce ^ num);
            seenTwice = ~seenOnce & (seenTwice ^ num);
        }

        return seenOnce;
    }



    public static void main(String[] args) {
//        System.out.println(singleNumber1(new int[]{4, 1, 2, 1, 2}));
//        System.out.println(singleNumber1(new int[]{2,2,1}));

        System.out.println(singleNumber2(new int[]{0, 1, 0, 1, 0, 1, 99}));
//        System.out.println(~3 & 3);
    }
}
