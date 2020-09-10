package com.sh.study.recursive;

import java.util.*;

/**
 * 40. 组合总和 II
 * 给定一个数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
 *
 * candidates 中的每个数字在每个组合中只能使用一次。
 *
 * 说明：
 *
 * 所有数字（包括目标数）都是正整数。
 * 解集不能包含重复的组合。
 * 示例 1:
 *
 * 输入: candidates = [10,1,2,7,6,1,5], target = 8,
 * 所求解集为:
 * [
 *   [1, 7],
 *   [1, 2, 5],
 *   [2, 6],
 *   [1, 1, 6]
 * ]
 * 示例 2:
 *
 * 输入: candidates = [2,5,2,1,2], target = 5,
 * 所求解集为:
 * [
 *   [1,2,2],
 *   [5]
 * ]
 * @Author zhouwenchen
 * @Data 2020/9/10/15
 **/
public class CombinationSum2 {

    /**
     * 使用回溯的思想实现
     * 注意：中的每个数字在每个组合中只能使用一次
     * @param candidates
     * @param target
     * @return
     */
    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        int len = candidates.length;
        if(len == 0){
            return res;
        }

        Arrays.sort(candidates);

        Deque<Integer> path = new ArrayDeque<>(len);
        dfs(candidates,len,0,target,path,res);
        return res;
    }

    private static void dfs(int[] candidates, int len, int begin, int target, Deque<Integer> path, List<List<Integer>> res) {
        if(target == 0){
            res.add(new ArrayList<>(path));
            return;
        }
        // 剪枝 操作
        for(int i = begin;i < len; i++){
            // 大剪枝
            if(target -candidates[i] < 0){
                continue;
            }

            // 小剪枝：同一层相同数值的结点，从第 2 个开始，候选数更少，结果一定发生重复，因此跳过，用 continue
            if(i > begin && candidates[i] == candidates[i-1]){
                continue;
            }
            path.add(candidates[i]);
            // 调试语句 ①
//             System.out.println("递归之前 => " + path + "，剩余 = " + (target - candidates[i]));

            dfs(candidates, len, i + 1, target - candidates[i], path, res);
            path.removeLast();
            // 调试语句 ②
//             System.out.println("递归之后 => " + path + "，剩余 = " + (target - candidates[i]));
        }
    }

    public static void main(String[] args) {
        int[] candidates = new int[]{10,1,2,7,6,1,5};
        List<List<Integer>> lists = combinationSum2(candidates, 8);
        lists.stream().forEach(integers -> System.out.println(integers));
    }
}
