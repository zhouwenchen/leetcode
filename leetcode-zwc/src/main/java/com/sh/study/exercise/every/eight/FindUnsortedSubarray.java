package com.sh.study.exercise.every.eight;

import java.util.Arrays;

/**
 * 581. 最短无序连续子数组
 * 给你一个整数数组 nums ，你需要找出一个 连续子数组 ，如果对这个子数组进行升序排序，那么整个数组都会变为升序排序。
 *
 * 请你找出符合题意的 最短 子数组，并输出它的长度。
 *
 *
 *
 * 示例 1：
 *
 * 输入：nums = [2,6,4,8,10,9,15]
 * 输出：5
 * 解释：你只需要对 [6, 4, 8, 10, 9] 进行升序排序，那么整个表都会变为升序排序。
 * 示例 2：
 *
 * 输入：nums = [1,2,3,4]
 * 输出：0
 * 示例 3：
 *
 * 输入：nums = [1]
 * 输出：0
 *
 * @author zhouwenchen
 * @date 2021/8/5 19:28
 **/
public class FindUnsortedSubarray {

    /**
     * （1）一个有序数组，一个原数组，
     * 遍历数组，从左向右，找到第一个两个不同数组的值，同理，可以找到最右边界的值，最后输出长度是多少
     *
     *（2）如果原数组就是有序的，，返回0
     * @param nums
     * @return
     */
    public static int findUnsortedSubarray(int[] nums) {
        // 判断原数组是否是有序的
        if(isSort(nums)){
            return 0;
        }
        int[] arr = new int[nums.length];
        System.arraycopy(nums,0,arr,0,nums.length);
        Arrays.sort(arr);
        int left = 0;
        while (arr[left] == nums[left]){
            left++;
        }
        int right = nums.length - 1;
        while (arr[right] == nums[right]){
            right--;
        }

        return right - left + 1;
    }

    private static boolean isSort(int[] nums) {
        for (int i = 1; i < nums.length; i++){
            if(nums[i-1] > nums[i]){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{2,6,4,8,10,9,15};
        System.out.println(findUnsortedSubarray(nums));
    }
}
