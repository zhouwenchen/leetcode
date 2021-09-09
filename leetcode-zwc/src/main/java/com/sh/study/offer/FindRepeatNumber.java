package com.sh.study.offer;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * 剑指 Offer 03. 数组中重复的数字
 * 找出数组中重复的数字。
 *
 *
 * 在一个长度为 n 的数组 nums 里的所有数字都在 0～n-1 的范围内。数组中某些数字是重复的，但不知道有几个数字重复了，也不知道每个数字重复了几次。请找出数组中任意一个重复的数字。
 *
 * 示例 1：
 *
 * 输入：
 * [2, 3, 1, 0, 2, 5, 3]
 * 输出：2 或 3
 *
 *
 * 限制：
 *
 * 2 <= n <= 100000
 *
 * @author zhouwenchen
 * @date 2021/9/9 10:33
 **/
public class FindRepeatNumber {

    /**
     * TODO 超时限制
     * @param nums
     * @return
     */
    public static int findRepeatNumber(int[] nums) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if(list.contains(nums[i])){
                return nums[i];
            }else {
                list.add(nums[i]);
            }
        }

        return -1;
    }

    public static int findRepeatNumber1(int[] nums) {
        HashSet set = new HashSet();
        for (int i = 0; i < nums.length; i++) {
            if(set.contains(nums[i])){
                return nums[i];
            }else {
                set.add(nums[i]);
            }
        }
        return -1;
    }

    /**
     *
     * @param nums
     * @return
     */
    public static int findRepeatNumber2(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < nums.length; i++) {
            int k = nums[i];
            if(k < 0 ){
                k+= n;
            }
            if(nums[k] < 0){
                return k;
            }
            nums[k] -= n;

        }
        return -1;
    }


    public static void main(String[] args) {
        System.out.println(findRepeatNumber(new int[]{2, 3, 1, 0, 2, 5, 3}));
        System.out.println(findRepeatNumber1(new int[]{2, 3, 1, 0, 2, 5, 3}));
        System.out.println(findRepeatNumber2(new int[]{2, 3, 1, 0, 2, 5, 3}));
    }

}
