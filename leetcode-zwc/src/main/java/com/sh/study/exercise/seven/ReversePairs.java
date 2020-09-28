package com.sh.study.exercise.seven;

/**
 * 493. 翻转对
 * 给定一个数组 nums ，如果 i < j 且 nums[i] > 2*nums[j] 我们就将 (i, j) 称作一个重要翻转对。
 *
 * 你需要返回给定数组中的重要翻转对的数量。
 *
 * 示例 1:
 *
 * 输入: [1,3,2,3,1]
 * 输出: 2
 * 示例 2:
 *
 * 输入: [2,4,3,5,1]
 * 输出: 3
 * 注意:
 *
 * 给定数组的长度不会超过50000。
 * 输入数组中的所有数字都在32位整数的表示范围内。
 *
 * @Author zhouwenchen
 * @Date  2020-09-28
 **/
public class ReversePairs {

    /**
     * 判断条件， i < j 而且 nums[i] > 2 * nums[j] ，相同的条件在于  nums[i] - nums[j] > nums[j]
     * 双层for循环一定会超时的
     *
     * @param nums
     * @return
     */
    public static int reversePairs(int[] nums) {
        if(nums == null){
            return 0;
        }

        int len = nums.length;
        int count = 0;
        for(int i = 0; i < len; i++){
            for (int j = i+1; j < len;j++){
                if( nums[i] -  nums[j] > nums[j]){
                    count++;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
//        int[] nums = {1, 3, 2, 3, 1}; // 2
//        int[] nums = {2,4,3,5,1};
        int[] nums = {2147483647,2147483647,2147483647,2147483647,2147483647,2147483647};
        System.out.println(reversePairs(nums));
    }
}