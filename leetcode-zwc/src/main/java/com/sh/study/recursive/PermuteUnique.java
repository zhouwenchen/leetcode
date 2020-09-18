package com.sh.study.recursive;

import java.util.ArrayList;
import java.util.Arrays;
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
 *
 * @Author zhouwenchen
 * @Date  2020-09-18
 **/
public class PermuteUnique {
    public static List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> ans  = new ArrayList<>();
        List<Integer> perm  = new ArrayList<>();
        if(nums == null || nums.length == 0){
            return ans ;
        }

        // 排序是为了剪枝的实现
        Arrays.sort(nums);
        boolean[] userd = new boolean[nums.length];
        backtrack(nums,ans , 0,perm,userd);

        return ans ;
    }

    /**
     * 使用回溯实现
     *
     * @param nums
     * @param ans
     * @param idx
     * @param perm
     */
    private static void backtrack(int[] nums, List<List<Integer>> ans, int idx, List<Integer> perm,boolean[] userd) {
        if(idx == nums.length){
            ans.add(new ArrayList<Integer>(perm));
            return;
        }

        for(int i = 0; i < nums.length; i++){
            if(userd[i] || (i > 0 && nums[i] == nums[i-1] && !userd[i-1])){
                continue;
            }
            perm.add(nums[i]);
            userd[i] = true;

            backtrack(nums,ans,idx+1,perm,userd);
            userd[i] = false;
            perm.remove(idx);
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,1,2};
        List<List<Integer>> lists = permuteUnique(nums);
        lists.stream().forEach(result->{
            System.out.println(result);
        });
    }
}
