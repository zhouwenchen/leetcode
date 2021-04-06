package com.sh.study.exercise.first;

import java.util.Arrays;

/**
 * 删除排序数据中的重复项
 * {1,1,2}  删除之后就是  {1,2}
 * 如果都删除呢？  {1,1,2} 删除之后就是{2}
 * @Author zhouwenchen
 * @Data 2020-08-2020/8/7-19
 **/
public class RemoveDuplicates {

    /**
     * {1,1,2}  删除之后就是  {1,2}
     * 删除重复项，仅保留一个重复的项
     *
     * @param arr
     * @return
     */
    public static int removeDuplicates(int[] arr){
        if(null == arr){
            return 0;
        }

        int size = 0;
        for(int i = 0; i < arr.length; i++){
            if(arr[i] != arr[size]){
                arr[++size] = arr[i];
            }
        }
        return size + 1;
    }

    /**
     * {1,1,2} 删除之后就是{2}
     * 删除所有的重复项，都不保留
     *
     * TODO
     * @param arr
     */
    public static int removeDuplicates2(int[] arr){
        if(null == arr){
            return 0;
        }

        int size = 0;
        for(int i = 0; i < arr.length; i++){
            if(arr[i] != arr[size]){
                arr[++size] = arr[i];
            }
        }
        return size + 1;
    }

    /**
     * 80. 删除有序数组中的重复项 II
     * 给你一个有序数组 nums ，请你 原地 删除重复出现的元素，使每个元素 最多出现两次 ，返回删除后数组的新长度。
     *
     * 不要使用额外的数组空间，你必须在 原地 修改输入数组 并在使用 O(1) 额外空间的条件下完成。
     *
     *
     *
     * 说明：
     *
     * 为什么返回数值是整数，但输出的答案是数组呢？
     *
     * 请注意，输入数组是以「引用」方式传递的，这意味着在函数里修改输入数组对于调用者是可见的。
     *
     * 你可以想象内部操作如下:
     *
     * // nums 是以“引用”方式传递的。也就是说，不对实参做任何拷贝
     * int len = removeDuplicates(nums);
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
     * 输入：nums = [1,1,1,2,2,3]
     * 输出：5, nums = [1,1,2,2,3]
     * 解释：函数应返回新长度 length = 5, 并且原数组的前五个元素被修改为 1, 1, 2, 2, 3 。 不需要考虑数组中超出新长度后面的元素。
     * 示例 2：
     *
     * 输入：nums = [0,0,1,1,1,1,2,3,3]
     * 输出：7, nums = [0,0,1,1,2,3,3]
     * 解释：函数应返回新长度 length = 7, 并且原数组的前五个元素被修改为 0, 0, 1, 1, 2, 3, 3 。 不需要考虑数组中超出新长度后面的元素。
     *
     * 原地替换，也就是删除替换
     * @param arr
     * @return
     */
    public static int removeDuplicates3(int[] arr){
        int length = arr.length;
        if (length < 2) {
            return arr.length;
        }
        int slow = 2,fast = 2;
        while (fast < length){
            if(arr[slow-2] != arr[fast]){
                arr[slow] = arr[fast];
                ++ slow;
            }
            ++ fast;
        }
        return slow;
    }

    public static void main(String[] args) {
//        int[] arr = new int[]{1,1,2,3,4,5,7,7};
//        int[] arr = new int[]{1,1,2};
        int[] arr = new int[]{1,1,1,2,2,3};
        System.out.println("数组的长度是：\t" + removeDuplicates3(arr));
        Arrays.stream(arr).forEach(o->System.out.print(o + "\t"));
    }
}
