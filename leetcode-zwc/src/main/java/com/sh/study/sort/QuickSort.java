package com.sh.study.sort;

import java.util.Arrays;

/**
 * 快速排序
 *
 * @Author zhouwenchen
 * @Data 2020/8/12/16
 **/
public class QuickSort {

    public static int quickSort(int[] nums, int start, int end) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        if (start < end) {
            int index = getIndex(nums, start, end);
            quickSort(nums, 0, index - 1);
            quickSort(nums, index + 1, end);
        }
        return -1;
    }

    private static int getIndex(int[] nums, int start, int end) {
        // 获取一个基准数据
        int tmp = nums[start];
        while (start < end) {
            // 从后找到一个小于 tmp的值
            while (start < end && nums[end] >= tmp) {
                end--;
            }
            // 找到了end 位置的值小于tmp 的值，或者此时 start >= end
            nums[start] = nums[end];
            // 从前找到一个大于  tmp 的值
            while (start < end && nums[start] <= tmp) {
                start++;
            }
            nums[end] = nums[start];
        }
        nums[start] = tmp;
        return start;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{46, 30, 82, 90, 56, 17, 95, 15};
        quickSort(nums, 0, nums.length - 1);
        Arrays.stream(nums).forEach(System.out::println);
    }
}
