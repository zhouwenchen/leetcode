package com.sh.study.exercise.every.nine;

import com.sh.study.node.TreeNode;

import java.util.HashMap;

/**
 * 437. 路径总和 III
 * 给定一个二叉树的根节点 root ，和一个整数 targetSum ，求该二叉树里节点值之和等于 targetSum 的 路径 的数目。
 *
 * 路径 不需要从根节点开始，也不需要在叶子节点结束，但是路径方向必须是向下的（只能从父节点到子节点）。
 *
 *
 *
 * 示例 1：
 *
 *
 *
 * 输入：root = [10,5,-3,3,2,null,11,3,-2,null,1], targetSum = 8
 * 输出：3
 * 解释：和等于 8 的路径有 3 条，如图所示。
 * 示例 2：
 *
 * 输入：root = [5,4,8,11,null,13,4,7,2,null,null,5,1], targetSum = 22
 * 输出：3
 *
 *
 * 提示:
 *
 * 二叉树的节点个数的范围是 [0,1000]
 * -109 <= Node.val <= 109
 * -1000 <= targetSum <= 1000
 *
 * @author zhouwenchen
 * @date 2021/9/28 9:35
 **/
public class PathSum {

    /**
     * 太难了这种题
     *
     * @param root
     * @param targetSum
     * @return
     */
    public static int pathSum(TreeNode root, int targetSum) {
        if(root == null){
            return 0;
        }
        int ret = rootSum(root,targetSum);
        ret += pathSum(root.left,targetSum);
        ret += pathSum(root.right,targetSum);
        return ret;
    }

    private static int rootSum(TreeNode root, int targetSum) {
        int ret = 0;
        if(root == null){
            return 0;
        }
        int val = root.val;
        if(val == targetSum){
            ret++;
        }
        ret += rootSum(root.left,targetSum-val);
        ret += rootSum(root.right,targetSum - val);
        return ret;
    }

    /**
     *
     * @param root
     * @param targetSum
     * @return
     */
    public static int pathSum1(TreeNode root, int targetSum) {
        HashMap<Integer, Integer> prefix = new HashMap<>();
        prefix.put(0, 1);
        return dfs(root, prefix, 0, targetSum);
    }

    private static int dfs(TreeNode root, HashMap<Integer, Integer> prefix, int cur, int targetSum) {
        if (root == null) {
            return 0;
        }
        int ret = 0;
        cur += root.val;
        ret = prefix.getOrDefault(cur - targetSum, 0);
        prefix.put(cur, prefix.getOrDefault(cur, 0) + 1);
        ret += dfs(root.left, prefix, cur, targetSum);
        ret += dfs(root.right, prefix, cur, targetSum);
        prefix.put(cur, prefix.getOrDefault(cur, 0) - 1);
        return ret;
    }

    public static void main(String[] args) {
        TreeNode node10 = new TreeNode(10);
        TreeNode node5 = new TreeNode(5);
        TreeNode node_3 = new TreeNode(-3);
        TreeNode node3 = new TreeNode(3);
        TreeNode node2 = new TreeNode(2);
        TreeNode node11 = new TreeNode(11);
        TreeNode node33 = new TreeNode(3);
        TreeNode node_2 = new TreeNode(-2);
        TreeNode node1 = new TreeNode(1);

        node10.left = node5;
        node10.right = node_3;
        node5.left = node3;
        node5.right = node2;
        node_3.right = node11;
        node3.left = node33;
        node3.right = node_2;
        node2.right = node1;

        System.out.println(pathSum(node10, 8));
        System.out.println(pathSum1(node10, 8));
    }
}
