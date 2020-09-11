package com.sh.study.exercise.four;

import java.util.Arrays;

/**
 * 33. 搜索旋转排序数组
 * 假设按照升序排序的数组在预先未知的某个点上进行了旋转。
 *
 * ( 例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] )。
 *
 * 搜索一个给定的目标值，如果数组中存在这个目标值，则返回它的索引，否则返回 -1 。
 *
 * 你可以假设数组中不存在重复的元素。
 *
 * 你的算法时间复杂度必须是 O(log n) 级别。
 *
 * 示例 1:
 *
 * 输入: nums = [4,5,6,7,0,1,2], target = 0
 * 输出: 4
 * 示例 2:
 *
 * 输入: nums = [4,5,6,7,0,1,2], target = 3
 * 输出: -1
 * @Author zhouwenchen
 * @Data 2020/9/11/11
 **/
public class Search {

    /**
     *
     * 使用异或的方式实现操作
     *
     * @param nums
     * @param target
     * @return
     */
    public static int search(int[] nums, int target) {
        int lo = 0, hi = nums.length - 1;
        while (lo < hi) {
            int mid = (lo + hi) / 2;
            if ((nums[0] > target) ^ (nums[0] > nums[mid]) ^ (target > nums[mid])) {
                lo = mid + 1;
            } else {
                hi = mid;
            }
        }
        return lo == hi && nums[lo] == target ? lo : -1;
    }

    public static void main(String[] args) {
//        int[] nums = new int[]{4,5,6,7,0,1,2};
//        int target = 0;

//        int[] nums = new int[]{4,5,6,7,0,1,2};
//        int target = 3;

//        int[] nums = new int[]{5,1,3};
//        int target = 3;
        int[] nums = new int[]{8,1,2,3,4,5,6,7};
        int target = 6;

        int index = search(nums, target);
        System.out.println(index);
    }
}
