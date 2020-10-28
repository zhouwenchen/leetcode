package com.sh.study.exercise.nine;

/**
 * 152. 乘积最大子数组
 * 给你一个整数数组 nums ，请你找出数组中乘积最大的连续子数组（该子数组中至少包含一个数字），并返回该子数组所对应的乘积。
 *
 *
 *
 * 示例 1:
 *
 * 输入: [2,3,-2,4]
 * 输出: 6
 * 解释: 子数组 [2,3] 有最大乘积 6。
 * 示例 2:
 *
 * 输入: [-2,0,-1]
 * 输出: 0
 * 解释: 结果不能为 2, 因为 [-2,-1] 不是子数组。
 *
 * @Author zhouwenchen
 * @Data 2020/10/28/14
 **/
public class MaxProduct {
    /**
     *
     * @param nums
     * @return
     */
    public static int maxProduct(int[] nums) {
        if(nums.length==1){
            return nums[0];
        }
        int imax = 1;
        int imin = 1;
        int maxValue = Integer.MIN_VALUE;
        for (int num: nums){
            if(num < 0){
                int tmp = imax;
                imax = imin;
                imin = tmp;
            }
            imax = Math.max(imax*num, num);
            imin = Math.min(imin*num, num);
            maxValue = Math.max(imax,maxValue);
        }
        return maxValue;
    }

    public static void main(String[] args) {
        System.out.println(maxProduct(new int[]{2, 3, -2, 4}));
        System.out.println(maxProduct(new int[]{-2,0,-1}));
        System.out.println(maxProduct(new int[]{-3,-1,-1}));
        System.out.println(maxProduct(new int[]{-2,3,-4}));
    }
}
