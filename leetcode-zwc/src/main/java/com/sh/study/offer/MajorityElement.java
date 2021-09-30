package com.sh.study.offer;

import java.util.Arrays;

/**
 * 剑指 Offer 39. 数组中出现次数超过一半的数字
 * 数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。
 *
 *
 *
 * 你可以假设数组是非空的，并且给定的数组总是存在多数元素。
 *
 *
 *
 * 示例 1:
 *
 * 输入: [1, 2, 3, 2, 2, 2, 5, 4, 2]
 * 输出: 2
 *
 *
 * 限制：
 *
 * 1 <= 数组长度 <= 50000
 *
 *
 *
 * @author zhouwenchen
 * @date 2021/9/28 10:07
 **/
public class MajorityElement {

    /**
     * 1：如果进行计数统计的话，很容易获取
     * 2：排序，那么中间的元素，一定是最多元素的个数
     * hash 的方法也是可行的
     * @param nums
     * @return
     */
    public static int majorityElement(int[] nums) {
        Arrays.sort(nums);
        int mid = nums.length/2;
        return nums[mid];
    }

    /**
     *
     * @param nums
     * @return
     */
    public static int majorityElement1(int[] nums) {
        int count = 0;
        Integer candidate = null;
        for (int num: nums){
            if(count == 0){
                candidate = num;
            }
            count += (num == candidate)? 1: -1;
        }
        return candidate;
    }

    public static void main(String[] args) {
        System.out.println(majorityElement(new int[]{1, 2, 3, 2, 2, 2, 5, 4, 2}));
        System.out.println(majorityElement1(new int[]{1, 2, 3, 2, 2, 2, 5, 4, 2}));
    }
}
