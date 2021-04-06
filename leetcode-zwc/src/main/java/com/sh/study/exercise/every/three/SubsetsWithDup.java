package com.sh.study.exercise.every.three;

import netscape.security.UserTarget;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 90. 子集 II
 * 给你一个整数数组 nums ，其中可能包含重复元素，请你返回该数组所有可能的子集（幂集）。
 *
 * 解集 不能 包含重复的子集。返回的解集中，子集可以按 任意顺序 排列。
 *
 *
 *
 * 示例 1：
 *
 * 输入：nums = [1,2,2]
 * 输出：[[],[1],[1,2],[1,2,2],[2],[2,2]]
 * 示例 2：
 *
 * 输入：nums = [0]
 * 输出：[[],[0]]
 *
 *
 * 提示：
 *
 * 1 <= nums.length <= 10
 * -10 <= nums[i] <= 10
 *
 * @author zhouwenchen
 * @date 2021/3/31 9:48
 **/
public class SubsetsWithDup {

    /**
     * dfs 实现操作
     * @param nums
     * @return
     */
    public static List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        Arrays.sort(nums);
        dfs(ans,path,0,nums);
        return ans;
    }

    private static void dfs(List<List<Integer>> ans, List<Integer> path, int index, int[] nums) {
        ans.add(new ArrayList<>(path));

        for (int i = index; i < nums.length; i++){
            if(i-1 >= index && nums[i-1] == nums[i]){
                continue;
            }
            path.add(nums[i]);
            dfs(ans,path,i+1,nums);
            path.remove(path.size()-1);
        }
    }

    public static void main(String[] args) {
//        subsetsWithDup(new int[]{1,2,2}).stream().forEach(o->{
//            o.stream().forEach(o1-> System.out.print(o1+"\t"));
//            System.out.println();
//        });

        subsetsWithDup(new int[]{5,5,5,5}).stream().forEach(o->{
            o.stream().forEach(o1-> System.out.print(o1+"\t"));
            System.out.println();
        });
    }
}
