package com.sh.study.exercise.first;

import org.omg.CORBA.INTERNAL;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 两数之和
 * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
 *
 * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍。
 *
 *  
 *
 * 示例:
 *
 * 给定 nums = [2, 7, 11, 15], target = 9
 *
 * 因为 nums[0] + nums[1] = 2 + 7 = 9
 * 所以返回 [0, 1]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/two-sum
 */
public class TwoSum {

    /**
     * 思考1：如果是排序数组的话，从目标数组 num【】 的末尾进行遍历，如果大于 target，那么 num[num.length--]
     * TODO 但是 排完序后，就没有了原来数组的位置了，这种方式不可取，
     * TODO 但是如果先排序的话，我们可以找到排序之后的数组中满足目标和的两个数字的和，可以再次遍历原数组。
     * @param nums
     * @param target
     * @return
     */
    public static int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        int start = 0;
        int end = nums.length - 1;
        int i = 0;
        while (start < end){
            if(target == nums[start] + nums[end]){
                result[i] = start;
                result[i+1] = end;
                return result;
            } else if(target > nums[start] + nums[end]){
                start++;
            } else {
                end--;
            }
        }

        return result;
    }

    /**
     * 使用一次遍历就可以实现， complete =  target - nums[i]
     * 若  complete 的值不存在 map中，将complete 和对应的下标索引存入到map中
     * b
     * @param nums
     * @param target
     * @return
     */
    public static int[] twoSum2(int[] nums, int target) {
        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int complete = target - nums[i];
            if(map.containsKey(complete)){
                return new int[]{map.get(complete),i};
            }
            map.put(nums[i],i);
        }

        return null;
    }

    /**
     * TODO review
     * @date 2020-10-13
     * @param nums
     * @param target
     * @return
     */
    public static int[] twoSum3(int[] nums, int target) {
        if(nums == null || nums.length < 2){
            return null;
        }
        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++){
            int value = target - nums[i];
            if(map.containsKey(value)){
                return new int[]{i,map.get(value)};
            } else{
                map.put(nums[i],i);
            }
        }
        return null;
    }

    /**
     * 剑指 Offer 57. 和为s的两个数字
     * 输入一个递增排序的数组和一个数字s，在数组中查找两个数，使得它们的和正好是s。如果有多对数字的和等于s，则输出任意一对即可。
     *
     *
     *
     * 示例 1：
     *
     * 输入：nums = [2,7,11,15], target = 9
     * 输出：[2,7] 或者 [7,2]
     * 示例 2：
     *
     * 输入：nums = [10,26,30,31,47,60], target = 40
     * 输出：[10,30] 或者 [30,10]
     *
     *
     * 限制：
     *
     * 1 <= nums.length <= 10^5
     * 1 <= nums[i] <= 10^6
     * @date 2021-09-22
     */
    public static int[] twoSum4(int[] nums, int target) {
        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++){
            int tmp = target - nums[i];
            if(map.get(tmp) != null){
                return new int[]{tmp,map.get(tmp)};
            }
            map.put(nums[i],tmp);
        }
        return null;
    }


    public static void main(String[] args) {
        int[] nums = new int[]{2,7,11,15};
        int target = 9;

//        int[] nums = new int[]{3,2,4};
//        int target = 6;


//        int[] result = twoSum3(nums, target);
        int[] result = twoSum4(nums, target);
        Arrays.stream(result).forEach(o-> System.out.println( o + "\t"));
    }
}
