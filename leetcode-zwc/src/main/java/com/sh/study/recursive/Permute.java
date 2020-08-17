package com.sh.study.recursive;

import java.util.*;

/**
 * 46. 全排列
 * 给定一个 没有重复 数字的序列，返回其所有可能的全排列。
 * <p>
 * 示例:
 * <p>
 * 输入: [1,2,3]
 * 输出:
 * [
 * [1,2,3],
 * [1,3,2],
 * [2,1,3],
 * [2,3,1],
 * [3,1,2],
 * [3,2,1]
 * ]
 * @link {https://leetcode-cn.com/problems/permutations/solution/quan-pai-lie-by-leetcode-solution-2/}
 * @Author zhouwenchen
 * @Data 2020/8/11/16
 **/
public class Permute {
    /**
     * 深度优先算法，使用递归，回溯算法实现的
     *
     * @param nums
     * @return
     */
    public static List<List<Integer>> permute(int[] nums) {
        int len = nums.length;
        List<List<Integer>> res = new ArrayList<>();
        if (len == 0) {
            return res;
        }
        // Stack 的替代类
        Deque<Integer> path = new ArrayDeque<Integer>();
        boolean[] userd = new boolean[len];
        dfs(nums, len, 0, path, userd, res);
        return res;
    }

    private static void dfs(int[] nums, int len, int depth, Deque<Integer> path, boolean[] userd, List<List<Integer>> res) {
        if (depth == len) {
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = 0; i < len; i++) {
            if (userd[i]) {
                continue;
            }
            path.addLast(nums[i]);
            userd[i] = true;
            dfs(nums, len, depth + 1, path, userd, res);
            // 回溯
            path.removeLast();
            userd[i] = false;
        }
    }

    public static void main(String[] args) {
        List<List<Integer>> lists = permute(new int[]{1, 2, 3});
        lists.stream().forEach(o -> System.out.print(o + "\t"));
    }
}
