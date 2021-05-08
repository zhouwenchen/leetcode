package com.sh.study.search;

import java.util.Arrays;
import java.util.List;

/**
 * 二分查找的几个变形问题
 * <p>
 * 1:查找第一个值等于给定值的元素
 * 2:查找最后一个值等于给定值的元素
 * 3:查找第一个大于等于给定值的元素
 * 4:查找最后一个小于等于给定值的元素
 *
 * @Author zhouwenchen
 * @Data 2020/8/13/16
 **/
public class BinarySearchDemo {

    /**
     * 1:查找第一个值等于给定值的元素
     * 思路：先根据二分查找，当 mid 满足 nums[mid] == target,需要再向前判断一位  nums[mid -1] 是否等于  target
     * 如果不等于，就直接返回mid
     * 如果等于，需要继续使用二分查找
     *
     * @return
     */
    public static int binarySearch1(int[] nums, int target) {
        if (nums == null) {
            return -1;
        }
        int start = 0;
        int end = nums.length - 1;

        // 判断第一个是否等于 target，如果等于，直接返回
        if (nums[start] == target) {
            return start;
        }
        while (start <= end) {
            int mid = start + (((end - start)) >> 1);
            if (nums[mid] == target) {
                // 需要判断前一位是否也等于 target,不等于直接返回
                if (nums[mid - 1] != target) {
                    return mid;
                }
                // nums[mid -1] == target
                end = mid - 1;
            } else if (nums[mid] < target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return -1;
    }

    /**
     * 2:查找最后一个值等于给定值的元素
     * 思路：先根据二分查找，当 mid 满足 nums[mid] == target,需要再向后判断一位  nums[mid + 1] 是否等于  target
     * 如果不等于，就直接返回mid
     * 如果等于，需要继续使用二分查找
     *
     * @param nums
     * @param target
     * @return
     */
    public static int binarySearch2(int[] nums, int target) {
        if (nums == null) {
            return -1;
        }
        int start = 0;
        int end = nums.length - 1;

        // 判断最后一个是否等于 target，如果等于，直接返回
        if (nums[end] == target) {
            return end;
        }
        while (start <= end) {
            int mid = start + (((end - start)) >> 1);
            if (nums[mid] == target) {
                // 需要判断后一位是否也等于 target,不等于直接返回
                if (nums[mid + 1] != target) {
                    return mid;
                }
                // nums[mid + 1] == target
                start = mid + 1;
            } else if (nums[mid] < target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return -1;
    }

    /**
     * 3:查找第一个大于等于给定值的元素
     * 这题思路同第一个  `查找第一个值等于给定值的元素`
     * <p>
     * 思路：先根据二分查找，当 mid 满足 nums[mid] == target,需要再向前判断一位  nums[mid -1] 是否等于  target
     * 如果不等于，就直接返回mid
     * 如果等于，需要继续使用二分查找
     *
     * @param nums
     * @param target
     * @return
     */
    public static int binarySearch3(int[] nums, int target) {
        if (nums == null) {
            return -1;
        }
        int start = 0;
        int end = nums.length - 1;

        // 判断第一个是否大于等于 target，如果满足，直接返回
        if (nums[start] >= target) {
            return start;
        }
        if(nums[end] < target){
            return -1;
        }
        while (start <= end) {
            int mid = start + (((end - start)) >> 1);
            if (nums[mid] == target) {
                // 需要判断前一位是否也大于等于 target,不满足 直接返回
                if (nums[mid - 1] != target) {
                    return mid;
                }
                // nums[mid + 1] == target
                end = mid - 1;
            } else if (nums[mid] < target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        if (end < start && nums[end] < target && nums[start] > target) {
            return start;
        }
        return -1;
    }

    /**
     * 4:查找最后一个小于等于给定值的元素
     * 思路同 `查找最后一个值等于给定值的元素`
     * <p>
     * 思路：先根据二分查找，当 mid 满足 nums[mid] == target,需要再向后判断一位  nums[mid + 1] 小于 等于  target
     * 如果不等于，就直接返回mid
     * 如果等于，需要继续使用二分查找
     *
     * @param nums
     * @param target
     * @return
     */
    public static int binarySearch4(int[] nums, int target) {
        if (nums == null) {
            return -1;
        }
        int start = 0;
        int end = nums.length - 1;

        // 判断最后一个是否大于等于 target，如果满足，直接返回
        if (nums[end] <= target) {
            return end;
        }
        if(nums[start] > target){
            return -1;
        }
        while (start <= end) {
            int mid = start + (((end - start)) >> 1);
            if (nums[mid] == target) {
                // 需要判断后一位是否也大于等于 target,不满足 直接返回
                if (nums[mid + 1] != target) {
                    return mid;
                }
                // nums[mid + 1] == target
                start = mid + 1;
            } else if (nums[mid] < target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        if(end < start && nums[end] < target && nums[start] > target){
            return end;
        }
        return -1;
    }

    /**
     * 给定一个有序数组，找出数组中下标与值相等的那些数。
     * @param nums
     */
    public static int getNumberSameAsIndex(int[] nums) {
        if(nums == null || nums.length == 0){
            return -1;
        }
        int start = 0;
        int end = nums.length;
        while (start < end){
            final int mid = start + ((end - start) >> 1);
            final int val = getVal(nums,mid);
            if(val < 0){
                start = mid + 1;
            } else {
                end = mid;
            }
        }
        if(start < nums.length && nums[start] == start){
            return start;
        }
        return -1;
    }

    private static int getVal(int[] nums, int mid) {
        if(nums[mid] < mid){
            return -1;
        }else if(nums[mid] == mid){
            return 0;
        }
        return 1;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 1, 2, 2, 2, 3, 4, 5, 5, 6, 6, 6, 9, 11, 15,15};
        // target 的测试取值，要包含多种情况 0,1,2,7,15,17 这几种情况
        int target = 7;
        System.out.println("查找第一个值等于给定值的元素:" + binarySearch1(nums, target));
        System.out.println("查找最后一个值等于给定值的元素:" + binarySearch2(nums, target));
        System.out.println("查找第一个大于等于给定值的元素:" + binarySearch3(nums, target));
        System.out.println("查找最后一个小于等于给定值的元素:" + binarySearch4(nums, target));
    }
}
