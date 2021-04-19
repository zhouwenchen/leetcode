package com.sh.study.exercise.every.four;

import java.util.Arrays;

/**
 * 27. 移除元素
 * 给你一个数组 nums 和一个值 val，你需要 原地 移除所有数值等于 val 的元素，并返回移除后数组的新长度。
 *
 * 不要使用额外的数组空间，你必须仅使用 O(1) 额外空间并 原地 修改输入数组。
 *
 * 元素的顺序可以改变。你不需要考虑数组中超出新长度后面的元素。
 *
 *
 *
 * 说明:
 *
 * 为什么返回数值是整数，但输出的答案是数组呢?
 *
 * 请注意，输入数组是以「引用」方式传递的，这意味着在函数里修改输入数组对于调用者是可见的。
 *
 * 你可以想象内部操作如下:
 *
 * // nums 是以“引用”方式传递的。也就是说，不对实参作任何拷贝
 * int len = removeElement(nums, val);
 *
 * // 在函数里修改输入数组对于调用者是可见的。
 * // 根据你的函数返回的长度, 它会打印出数组中 该长度范围内 的所有元素。
 * for (int i = 0; i < len; i++) {
 *     print(nums[i]);
 * }
 *
 *
 * 示例 1：
 *
 * 输入：nums = [3,2,2,3], val = 3
 * 输出：2, nums = [2,2]
 * 解释：函数应该返回新的长度 2, 并且 nums 中的前两个元素均为 2。你不需要考虑数组中超出新长度后面的元素。例如，函数返回的新长度为 2 ，而 nums = [2,2,3,3] 或 nums = [2,2,0,0]，也会被视作正确答案。
 * 示例 2：
 *
 * 输入：nums = [0,1,2,2,3,0,4,2], val = 2
 * 输出：5, nums = [0,1,4,0,3]
 * 解释：函数应该返回新的长度 5, 并且 nums 中的前五个元素为 0, 1, 3, 0, 4。注意这五个元素可为任意顺序。你不需要考虑数组中超出新长度后面的元素。
 *
 *
 * 提示：
 *
 * 0 <= nums.length <= 100
 * 0 <= nums[i] <= 50
 * 0 <= val <= 100
 * 通过次数349,441提交次数588,077
 *
 * @author zhouwenchen
 * @date 2021/4/19 9:51
 **/
public class RemoveElement {

    public static int removeElement(int[] nums, int val) {
        if(nums == null || nums.length == 1 &&nums[0] == val){
            return 0;
        }
        int start = 0;
        int end = nums.length -1;
        int size = nums.length;
        while (start <= end){
            // 查找一个等于 val 的值，表示
            while (start <= end && nums[start] != val){
                start++;
            }
            // 此时表示 nums[start] 的值等于 val,需要从 end 查找一个不等于 val的值，进行替换
            while (start <= end && nums[end] == val){
                end--;
                size--;
            }

            // 交换 成功
            if(start < end){
                swap(nums,start,end);
            }
        }
        return size;
    }

    private static void swap(int[] nums, int start, int end) {
        int tmp = nums[start];
        nums[start] = nums[end];
        nums[end] = tmp;
    }


    /**
     * 第二种的表示方法实现操作,这个表示还可以
     *
     * @param nums
     * @param val
     * @return
     */
    public static int removeElement1(int[] nums, int val) {
        if (nums == null || nums.length == 1 && nums[0] == val) {
            return 0;
        }
        int size = nums.length;
        int start = 0;
        int end = nums.length - 1;
        while (start <= end){
            // 先从 后面找到一个 不等于 val的值
            while (start <= end && nums[end] == val){
                size--;
                end--;
            }
            // 在从前面找到一个
            if(start<=end && nums[start] == val){
                size--;
                nums[start] = nums[end];
                end--;
            }
            start++;
        }
        return size;
    }


    public static void main(String[] args) {
        int[] nums = {0, 1, 2, 2, 3, 0, 4, 2};
//        int[] nums = new int[]{3, 2, 2, 3};
//        int[] nums = new int[]{1};
//        int[] nums = new int[]{3,3};
        int val = 2;
        int size = removeElement1(nums,val);
        Arrays.stream(nums).limit(nums.length).forEach(o-> System.out.print(o+"\t"));
        System.out.println();
        System.out.println(size);
//        System.out.println(removeElement(nums, 3));
//        0,1,2,2,3,0,4,2
//        System.out.println(removeElement(new int[]{3, 2, 2, 3}, 3));
    }

}
