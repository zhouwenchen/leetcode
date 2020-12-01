package com.sh.study.exercise.every;

import org.omg.CORBA.INTERNAL;

import java.util.Arrays;

/**
 * 34. 在排序数组中查找元素的第一个和最后一个位置
 * 给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。
 *
 * 如果数组中不存在目标值 target，返回 [-1, -1]。
 *
 * 进阶：
 *
 * 你可以设计并实现时间复杂度为 O(log n) 的算法解决此问题吗？
 *
 *
 * 示例 1：
 *
 * 输入：nums = [5,7,7,8,8,10], target = 8
 * 输出：[3,4]
 * 示例 2：
 *
 * 输入：nums = [5,7,7,8,8,10], target = 6
 * 输出：[-1,-1]
 * 示例 3：
 *
 * 输入：nums = [], target = 0
 * 输出：[-1,-1]
 *
 *
 * 提示：
 *
 * 0 <= nums.length <= 105
 * -109 <= nums[i] <= 109
 * nums 是一个非递减数组
 * -109 <= target <= 109
 *
 * @author ：zhouwenchen
 * @date ： 2020/12/1 9:39
 */
public class SearchRange {
    /**
     * 可以使用一次遍历，判断是否有目标值
     * TODO 由于时间复杂度不是 O(logn),时间复杂度  是  O(n)
     * @param nums
     * @param target
     * @return
     */
    public static int[] searchRange(int[] nums, int target) {
        if(nums == null ){
            return new int[]{-1,-1};
        }
        int low = Integer.MAX_VALUE;
        int high = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] == target){
                low = Math.min(low,i);
                high = Math.max(high,i);
            }
        }
        int[] result = new int[2];
        if(low == Integer.MAX_VALUE && high == Integer.MIN_VALUE){
            Arrays.fill(result,-1);
        } else {
            result[0] = low;
            result[1] = high;
        }
        return result;
    }

    /**
     * 应该使用二分查找法来实现操作，这也就相当于，查找第一个出现的位置和最后一个位置
     * @param nums
     * @param target
     * @return
     */
    public static int[] searchRange1(int[] nums, int target) {
       return recur(nums,0,nums.length -1,target);
    }

    private static int[] recur(int[] nums, int left, int right, int target) {
        while (left <= right){
            int mid = (left + right) >> 1;
            if(nums[mid] > target){
                right = mid - 1;
            } else if(nums[mid] < target){
                left = mid + 1;
            } else {
                if(nums[left] != target){
                    // 因为left不是target ,所以需要往右移动
                    left = recur(nums,left+1,right,target)[0];
                }
                if(nums[right] != target){
                    right = recur(nums,left,right-1,target)[1];
                }
                return new int[]{left,right};
            }
        }
        return new int[]{-1,-1};
    }

    public static void main(String[] args) {
//        Arrays.stream(searchRange1(new int[]{5, 7, 7, 8, 8, 10}, 8)).forEach(System.out::println);
//        Arrays.stream(searchRange1(new int[]{5, 7, 7, 8, 8,8,8, 10}, 8)).forEach(System.out::println);
//        Arrays.stream(searchRange1(new int[]{5, 7, 7, 8, 8, 10}, 6)).forEach(System.out::println);
//        Arrays.stream(searchRange1(new int[]{}, 6)).forEach(System.out::println);
        Arrays.stream(searchRange1(new int[]{1}, 1)).forEach(System.out::println);
    }
}
