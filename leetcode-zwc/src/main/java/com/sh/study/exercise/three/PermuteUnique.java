package com.sh.study.exercise.three;

import java.util.ArrayList;
import java.util.List;

/**
 * 47. 全排列 II
 * 给定一个可包含重复数字的序列，返回所有不重复的全排列。
 *
 * 示例:
 *
 * 输入: [1,1,2]
 * 输出:
 * [
 *   [1,1,2],
 *   [1,2,1],
 *   [2,1,1]
 * ]
 * @Author zhouwenchen
 * @Data 2020/8/19/12
 **/
public class PermuteUnique {
    /**
     *
     * @param nums
     * @return
     */
    public static List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        return res;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,1,2};
        permuteUnique(nums);
    }
}
