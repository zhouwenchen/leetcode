package com.sh.study.offer;

/**
 * 剑指 Offer 53 - II. 0～n-1中缺失的数字
 * 一个长度为n-1的递增排序数组中的所有数字都是唯一的，并且每个数字都在范围0～n-1之内。在范围0～n-1内的n个数字中有且只有一个数字不在该数组中，请找出这个数字。
 *
 *
 *
 * 示例 1:
 *
 * 输入: [0,1,3]
 * 输出: 2
 * 示例 2:
 *
 * 输入: [0,1,2,3,4,5,6,7,9]
 * 输出: 8
 *
 *
 * 限制：
 *
 * 1 <= 数组长度 <= 10000
 *
 * @author zhouwenchen
 * @date 2021/9/9 15:06
 **/
public class MissingNumber {

    /**
     * 二分法
     * @param nums
     * @return
     */
    public static int missingNumber(int[] nums) {
        int left = 0,right = nums.length - 1;
        int mid = 0;
        while (left < right){
            mid = (left + right) / 2;
            if(nums[mid] == mid){
                left = mid+1;
            }else if(nums[mid] > mid){
                right = mid;
            }
        }
        while (mid < nums.length && nums[mid] == mid){
            if(mid + 1 == nums.length || mid+1 < nums.length && nums[mid+1] != mid){
                 mid+=1;
            }
        }
        return mid;
    }

    /**
     * 也是二分法，但是感觉比我写的优雅
     * @param nums
     * @return
     */
    public static int missingNumber1(int[] nums) {
        int i = 0, j = nums.length - 1;
        while (i < j) {
            int m = (i + j) / 2;
            if (nums[m] == m) {
                i = m + 1;
            } else {
                j = m - 1;
            }
        }
        return i;
    }

    public static void main(String[] args) {
        System.out.println(missingNumber1(new int[]{0, 1, 3}));
        System.out.println(missingNumber1(new int[]{0,1,2,3,4,5,6,7,9}));
        System.out.println(missingNumber1(new int[]{1,2,3,4,5,6,7,8,9}));
        System.out.println(missingNumber1(new int[]{0,2,3,4,5,6,7,8,9}));
        System.out.println(missingNumber1(new int[]{0}));
        System.out.println(missingNumber1(new int[]{0,1}));

    }
}
