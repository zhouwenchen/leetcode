package com.sh.study.exercise.every.three;

import java.util.ArrayList;
import java.util.List;

/**
 * 78. 子集
 * 给你一个整数数组 nums ，数组中的元素 互不相同 。返回该数组所有可能的子集（幂集）。
 *
 * 解集 不能 包含重复的子集。你可以按 任意顺序 返回解集。
 *
 *
 *
 * 示例 1：
 *
 * 输入：nums = [1,2,3]
 * 输出：[[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
 * 示例 2：
 *
 * 输入：nums = [0]
 * 输出：[[],[0]]
 *
 * @author zhouwenchen
 * @date 2021/3/31 10:25
 **/
public class Subsets {

    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        dfs(ans,path,0,nums);
        return ans;
    }

    private static void dfs(List<List<Integer>> ans, List<Integer> path, int index, int[] nums) {
        if(index == nums.length ){
            ans.add(new ArrayList<>(path));
            return;
        }
        path.add(nums[index]);
        dfs(ans,path,index+1,nums);
        path.remove(path.size()-1);
        dfs(ans,path,index+1,nums);
    }

    public static void main(String[] args) {
        subsets(new int[]{1,2,3}).stream().forEach(o->{
            o.stream().forEach(o1-> System.out.print(o1+"\t"));
            System.out.println();
        });
    }

}
