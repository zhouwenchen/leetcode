package com.sh.study.exercise.first;

import java.util.Arrays;

/**
 * 283. 移动零
 * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 * <p>
 * 示例:
 * <p>
 * 输入: [0,1,0,3,12]
 * 输出: [1,3,12,0,0]
 * 说明:
 * <p>
 * 必须在原数组上操作，不能拷贝额外的数组。
 * 尽量减少操作次数。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/move-zeroes
 */
public class MoveZeroes {
    /**
     * 使用快慢指针实现，慢指针指向需要交换的位置，快指针指向不为0的值，并交换快慢指针的位置
     *
     * @param nums
     */
    public static void moveZeroes(int[] nums) {
        if (nums == null) {
            return;
        }
        int i = 0;
        int j = 0;
        for (; i < nums.length; i++) {
            if (nums[i] != 0) {
                swap(nums, i, j);
                j++;
            }
        }
    }

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    /**
     * 使用快慢指针，第一个 start 如果是0的话，从此位置找到第一个不是0的替换
     * @date 202011190938
     * @param nums
     */
    public static void moveZeroes1(int[] nums) {
        int fast = 0;
        int slow = 0;
        for (; fast < nums.length;fast++){
            if(nums[fast] != 0){
                swap(nums,fast,slow);
                slow++;
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{0, 1, 0, 3, 12};
//        moveZeroes(nums);
        moveZeroes1(nums);
        Arrays.stream(nums).forEach(o -> System.out.print(o + "\t"));
    }
}