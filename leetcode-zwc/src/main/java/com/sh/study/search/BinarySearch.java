package com.sh.study.search;

/**
 * 二分查找,查找指定数据，并返回目标数据在数据中的位置，-1 表示数组中没有指定的数据
 *
 * @Author zhouwenchen
 * @Data 2020/8/13/15
 **/
public class BinarySearch {

    /**
     * 二分查找 指定目标的数据
     * 使用 while 循环实现
     *
     * @param nums
     * @param target
     * @return
     */
    public static int binarySearch(int[] nums, int target) {
        if (nums == null) {
            return -1;
        }
        int low = 0;
        int high = nums.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }

    /**
     * 使用递归实现
     *
     * @param nums
     * @param target
     * @return
     */
    public static int binarySearch0(int[] nums, int start, int end, int target) {
        if (nums == null || start > end) {
            return -1;
        }
        int mid = (start + end) >> 1;
        if (nums[mid] == target) {
            return mid;
        } else if (nums[mid] > target) {
            return binarySearch0(nums, start, mid - 1, target);
        } else {
            return binarySearch0(nums, mid + 1, end, target);
        }
    }

    public static void main(String[] args) {
//        int[] nums = {1, 3, 5, 7, 8, 11, 19, 23, 27, 33, 45, 55, 67, 98};
//        int target = 27;

//        int[] nums = {1,3,5,7,9,11};
        int[] nums = {1,3,5,7,9};
        int target = 5;
        System.out.println("location is " + binarySearch(nums, target));
//        System.out.println("location is " +  binarySearch0(nums, 0, nums.length - 1, target));
    }
}
