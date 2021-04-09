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

    /**
     * 2020-10-22 第二次实现思路
     * 基于二分查找方法实现操作
     * @param nums
     * @param target
     * @return
     */
    public static int search1(int[] nums, int target) {
        int n = nums.length;
        if (n == 0){
            return -1;
        }
        if(n == 1){
            return nums[0] == target? 0: -1;
        }

        int l = 0;
        int r = n - 1;
        while (l <= r){
            int mid = (l + r )/ 2;
            if(nums[mid] == target){
                return mid;
            }
            if(nums[0] <= nums[mid]){  // 表示左边是排好序的数组
                if(nums[0] <= target && target < nums[mid]){
                    r = mid - 1;
                } else{
                    l = mid + 1;
                }
            } else {
                if(nums[mid] < target && target <= nums[n-1]){
                    l = mid + 1;
                } else{
                    r = mid - 1;
                }
            }
        }
        return -1;
    }

    /**
     * 81. 搜索旋转排序数组 II
     * 假设按照升序排序的数组在预先未知的某个点上进行了旋转。
     *
     * ( 例如，数组 [0,0,1,2,2,5,6] 可能变为 [2,5,6,0,0,1,2] )。
     *
     * 编写一个函数来判断给定的目标值是否存在于数组中。若存在返回 true，否则返回 false。
     *
     * 示例 1:
     *
     * 输入: nums = [2,5,6,0,0,1,2], target = 0
     * 输出: true
     * 示例 2:
     *
     * 输入: nums = [2,5,6,0,0,1,2], target = 3
     * 输出: false
     *
     * @param nums
     * @param target
     * @date 2020-10-22
     * @return
     */
    public static boolean search2(int[] nums, int target) {
        if(nums == null){
            return false;
        }
        int len = nums.length;
        if(len == 1){
            return nums[0] == target;
        }
        int l = 0;
        int r = len - 1;
        while (l <= r){
            int mid = (l + r) / 2;
            if(target == nums[mid]){
                return true;
            }

            // 如果此时中间节点的值和左右节点相同，我们需要更新 l 和 r 的值
            if(nums[l] == nums[mid] && nums[mid] == nums[r]){
                ++l;
                --r;
            }else if(nums[l] <= nums[mid]){
                if(nums[l] <= target && target < nums[mid]){
                    r = mid - 1;
                }else {
                    l = mid + 1;
                }
            }else{
                if(nums[mid] < target && target <= nums[len-1]){
                    l = mid + 1;
                }else {
                    r = mid - 1;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
//        int[] nums = new int[]{4,5,6,7,0,1,2};
//        int target = 0;

//        int[] nums = new int[]{4,5,6,7,0,1,2};
//        int target = 3;

//        int[] nums = new int[]{5,1,3};
//        int target = 3;
//        int[] nums = new int[]{8,1,2,3,4,5,6,7};
//        int target = 6;

//        int index = search1(nums, target);
//        System.out.println(index);

        System.out.println(search2(new int[]{2, 5, 6, 0, 0, 1, 2}, 6));

    }
}
