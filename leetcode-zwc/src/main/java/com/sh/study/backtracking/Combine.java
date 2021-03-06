package com.sh.study.backtracking;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * 77. 组合
 * 给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合。
 *
 * 示例:
 *
 * 输入: n = 4, k = 2
 * 输出:
 * [
 *   [2,4],
 *   [3,4],
 *   [2,3],
 *   [1,2],
 *   [1,3],
 *   [1,4],
 * ]
 * @author zhouwenchen
 * @date 2020-08-18 22:45
 */
public class Combine {
    public static List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        if(k <= 0 || n < k){
            return res;
        }
        // 从1 开始是题目设定的
        Deque<Integer> path = new ArrayDeque<>();
        dfs(n,k,1,path,res);

        return res;
    }

    private static void dfs(int n, int k, int start, Deque<Integer> path, List<List<Integer>> res) {
        // 终止的条件
        if(path.size() == k){
            res.add(new ArrayList<>(path));
            return;
        }
        // 循环调用的结果
        for (int i = start; i <=n;i++){
            // 剪枝操作
            path.add(i);
            dfs(n,k,i+1,path,res);
            path.removeLast();
        }
    }

    public static void main(String[] args) {
        List<List<Integer>> result = combine(4, 2);
        result.stream().forEach(o-> System.out.print(o + "\t"));
    }
}
