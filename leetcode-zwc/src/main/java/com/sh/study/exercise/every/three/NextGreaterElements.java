package com.sh.study.exercise.every.three;

import java.util.*;

/**
 * 503. 下一个更大元素 II
 * 给定一个循环数组（最后一个元素的下一个元素是数组的第一个元素），输出每个元素的下一个更大元素。数字 x 的下一个更大的元素是按数组遍历顺序，这个数字之后的第一个比它更大的数，这意味着你应该循环地搜索它的下一个更大的数。如果不存在，则输出 -1。
 *
 * 示例 1:
 *
 * 输入: [1,2,1]
 * 输出: [2,-1,2]
 * 解释: 第一个 1 的下一个更大的数是 2；
 * 数字 2 找不到下一个更大的数；
 * 第二个 1 的下一个最大的数需要循环搜索，结果也是 2。
 *
 */
public class NextGreaterElements {

    public static int[] nextGreaterElements(int[] nums) {
        int m = nums.length;
        int[] ret = new int[m];
        Arrays.fill(ret,-1);
        Deque<Integer> deque = new ArrayDeque<>();
        for (int i = 0; i < 2 * m - 1;i++){
            while (!deque.isEmpty() && nums[deque.peek()] < nums[i%m]){
                ret[deque.pop()] = nums[i%m];
            }
            deque.push(i %m);
        }
        return ret;
    }

    /**
     * 496. 下一个更大元素 I
     * 给你两个 没有重复元素 的数组 nums1 和 nums2 ，其中nums1 是 nums2 的子集。
     *
     * 请你找出 nums1 中每个元素在 nums2 中的下一个比其大的值。
     *
     * nums1 中数字 x 的下一个更大元素是指 x 在 nums2 中对应位置的右边的第一个比 x 大的元素。如果不存在，对应位置输出 -1 。
     *
     *
     *
     * 示例 1:
     *
     * 输入: nums1 = [4,1,2], nums2 = [1,3,4,2].
     * 输出: [-1,3,-1]
     * 解释:
     *     对于 num1 中的数字 4 ，你无法在第二个数组中找到下一个更大的数字，因此输出 -1 。
     *     对于 num1 中的数字 1 ，第二个数组中数字1右边的下一个较大数字是 3 。
     *     对于 num1 中的数字 2 ，第二个数组中没有下一个更大的数字，因此输出 -1 。
     * 示例 2:
     *
     * 输入: nums1 = [2,4], nums2 = [1,2,3,4].
     * 输出: [3,-1]
     * 解释:
     *     对于 num1 中的数字 2 ，第二个数组中的下一个较大数字是 3 。
     *     对于 num1 中的数字 4 ，第二个数组中没有下一个更大的数字，因此输出 -1 。
     *
     *  使用的是单调栈实现操作
     *
     * @param nums1
     * @param nums2
     * @return
     */
    public static int[] nextGreaterElement(int[] nums1, int[] nums2) {
        // 将 nums2 遍历，存入到hash中，key是值，value为索引位置
        Map<Integer,Integer> map = new HashMap<>();
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = nums2.length - 1; i >= 0; i--){
            int num = nums2[i];
            while (!stack.isEmpty() && num >= stack.peek()){
                stack.pop();
            }
            map.put(num,stack.isEmpty()?-1: stack.peek());
            stack.push(num);
        }
        int[] res = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++) {
            res[i] = map.get(nums1[i]);
        }
        return res;
    }

    public static void main(String[] args) {
//        Arrays.stream(nextGreaterElements(new int[]{1, 2, 1})).forEach(System.out::println);
        Arrays.stream(nextGreaterElement(new int[]{2, 4}, new int[]{1, 2, 3, 4})).forEach(System.out::println);
    }
}
