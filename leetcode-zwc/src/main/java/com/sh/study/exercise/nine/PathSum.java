package com.sh.study.exercise.nine;

import com.sh.study.node.TreeNode;
import com.sh.study.util.NodeUtil;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * 113. 路径总和 II
 * 给定一个二叉树和一个目标和，找到所有从根节点到叶子节点路径总和等于给定目标和的路径。
 *
 * 说明: 叶子节点是指没有子节点的节点。
 *
 * 示例:
 * 给定如下二叉树，以及目标和 sum = 22，
 *
 *               5
 *              / \
 *             4   8
 *            /   / \
 *           11  13  4
 *          /  \    / \
 *         7    2  5   1
 * 返回:
 *
 * [
 *    [5,4,11,2],
 *    [5,8,4,5]
 * ]
 *
 * @Author zhouwenchen
 * @Data 2020/10/23/17
 **/
public class PathSum {

    /**
     * 回溯的思路实现
     */
    public static List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> result = new ArrayList<>();
        if(root == null){
            return result;
        }
        Deque<Integer> path = new LinkedList<Integer>();
        dfs(root, sum,path,result);
        return result;
    }

    /**
     *
     * @param root
     * @param sum
     * @param path
     * @param result
     */
    private static void dfs(TreeNode root, int sum, Deque<Integer> path, List<List<Integer>> result) {
        if(root == null){
            return;
        }
        path.offerLast(root.val);
        sum -= root.val;
        if(root.left == null && root.right == null && sum == 0){
            result.add(new LinkedList<Integer>(path));
        }
        dfs(root.left, sum, path, result);
        dfs(root.right,sum,path, result);
        path.pollLast();
    }

    public static void main(String[] args) {
        TreeNode head = NodeUtil.createTreeNodeByArr(new int[]{5, 4, 8, 11,0, 13, 4, 7, 2, 0, 0,0,0, 5, 1});
        pathSum(head, 22).stream().forEach(System.out::println);
    }
}
