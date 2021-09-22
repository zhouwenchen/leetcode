package com.sh.study.offer;

import java.util.Arrays;

/**
 * 剑指 Offer 21. 调整数组顺序使奇数位于偶数前面
 * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有奇数位于数组的前半部分，所有偶数位于数组的后半部分。
 *
 *
 *
 * 示例：
 *
 * 输入：nums = [1,2,3,4]
 * 输出：[1,3,2,4]
 * 注：[3,1,2,4] 也是正确的答案之一。
 *
 *
 * 提示：
 *
 * 0 <= nums.length <= 50000
 * 1 <= nums[i] <= 10000
 *
 * @author zhouwenchen
 * @date 2021/9/18 11:59
 **/
public class Exchange {

    /**
     * 使用双指针操作
     * @param nums
     * @return
     */
    public static int[] exchange(int[] nums) {
        int start = 0;
        int end = nums.length - 1;
        while (start < end){
            // 先查找第一偶数
            while (start < end && nums[start] % 2 != 0){
                start++;
            }

            // 从后查找第一个计数
            while (start < end && nums[end] % 2 == 0){
                end--;
            }
            // 交换
            swap(nums,start,end);
        }
        return nums;
    }

    private static void swap(int[] nums, int start, int end) {
        int tmp = nums[start];
        nums[start] = nums[end];
        nums[end] = tmp;
    }

    public static void main(String[] args) {
        Arrays.stream(exchange(new int[]{1, 2, 3, 4})).forEach(System.out::println);
    }
}
