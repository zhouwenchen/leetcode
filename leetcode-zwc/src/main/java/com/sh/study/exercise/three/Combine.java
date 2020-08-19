package com.sh.study.exercise.three;

import java.util.*;

/**
 * 77. 组合
 * 给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合。
 * <p>
 * 示例:
 * <p>
 * 输入: n = 4, k = 2
 * 输出:
 * [
 * [2,4],
 * [3,4],
 * [2,3],
 * [1,2],
 * [1,3],
 * [1,4],
 * ]
 *
 * @Author zhouwenchen
 * @Data 2020/8/19/10
 **/
public class Combine {
    /**
     * 第一种解法
     * 使用递归实现，但是[1,4] 和 [4,1] 应该作为一个
     * TODO 这种解法，会有 [1,4] 和 [4,1] 这个应该作为重复的数据
     *
     * @param n 1-n 个数
     * @param k 每个组合中有 k 个数
     * @return 返回 1 ... n 中所有可能的 k 个数的组合
     */
    public static List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        if (k == 0) {
            return res;
        }
        int[] nums = new int[n];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = i + 1;
        }
        Deque<Integer> path = new ArrayDeque<Integer>();
        boolean[] used = new boolean[n];
        dfs(nums, n, 0, path, used, res, k);
        return res;
    }

    private static void dfs(int[] nums, int len, int depth, Deque<Integer> path, boolean[] used, List<List<Integer>> res, int k) {
        if (depth == k) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = depth; i < len; i++) {
            if (used[i]) {
                continue;
            }
            path.addLast(nums[i]);
            used[i] = true;

            dfs(nums, len, i + 1, path, used, res, k);
            path.removeLast();
            used[i] = false;
        }
    }

    /**
     * TODO，这种解法还是有问题的
     * 还是有部分重复的问题数据
     */
    private static List<List<Integer>> res = new ArrayList<>();
    public static List<List<Integer>> combine1(int n, int k) {
        // 判断
        if(n < 0 || k < 0 || n < k){
            return res;
        }
        findCombinations(n,k,1,new Stack<Integer>());
        return res;
    }

    private static void findCombinations(int n, int k, int begin, Stack<Integer> stack) {
        if(stack.size() == k){
            res.add(new ArrayList<>(stack));
            return;
        }
        for(int i = begin; i <= n - (k - stack.size()) + 1; i++){
            stack.push(i);
            findCombinations(n, k, begin+1, stack);
            stack.pop();
        }
    }

    /**
     * 第三种尝试操作 // TODO 这种解法是正确的
     * @param n
     * @param k
     * @return
     */
    public static List<List<Integer>> combine2(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        getAns(1,n, k, new ArrayList<Integer>(), res);
        return res;
    }

    private static void getAns(int start, int n, int k, ArrayList<Integer> temp, List<List<Integer>> res) {
        if (temp.size() == k) {
            res.add(new ArrayList<>(temp));
            return;
        }
        for (int i = start; i <= n; i++) {
            temp.add(i);
            getAns(i + 1, n, k, temp, res);
            temp.remove(temp.size() - 1);
        }
    }

    public static void main(String[] args) {
        List<List<Integer>> result = combine(4, 2);
//        List<List<Integer>> result = combine(4,3);
        result.stream().forEach(o -> System.out.println(o));
    }
}
