package com.sh.study.exercise.nine;

import com.sh.study.node.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 112. 路径总和
 * 给定一个二叉树和一个目标和，判断该树中是否存在根节点到叶子节点的路径，这条路径上所有节点值相加等于目标和。
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
 *          /  \      \
 *         7    2      1
 * 返回 true, 因为存在目标和为 22 的根节点到叶子节点的路径 5->4->11->2。
 *
 * @Author zhouwenchen
 * @Data 2020/10/23/16
 **/
public class HasPathSum {
    /**
     * 使用两个队列实现，一个用于遍历二叉树的数据，一个用于存储二叉树中的值
     * BFS
     *
     * @param root
     * @param sum
     * @return
     */
    public static boolean hasPathSum(TreeNode root, int sum) {
        if(root == null){
            return false;
        }
        Queue<TreeNode> queNode = new LinkedList<>();
        Queue<Integer> queVal = new LinkedList<>();
        queNode.offer(root);
        queVal.offer(root.val);
        while (!queNode.isEmpty()){
            TreeNode node = queNode.poll();
            Integer temp = queVal.poll();
            if(node.left == null && node.right == null){
                if(temp == sum){
                    return true;
                }
                continue;
            }
            if(node.left != null){
                queNode.offer(node.left);
                queVal.offer(node.left.val + temp);
            }
            if(node.right != null){
                queNode.offer(node.right);
                queVal.offer(node.right.val + temp);
            }
        }
        return false;
    }

    /**
     * DFS 深度优先遍历算法实现遍历操作
     * 使用递归实现操作
     * @param root
     * @param sum
     * @return
     */
    public static boolean hasPathSum1(TreeNode root, int sum) {
        if(root.left == null && root.right == null){
            return sum == root.val;
        }
        return hasPathSum1(root.left, sum - root.val) || hasPathSum1(root.right, sum - root.val);
    }

    /**
     * 回溯
     */
    public static boolean hasPathSum2(TreeNode root, int sum) {
        if(root == null){
            return false;
        }
        if(sum == root.val && root.left == null && root.right == null){
            return true;
        }
        if(root.left != null && hasPathSum2(root.left,sum - root.val)){
            return true;
        }
        if(root.right != null && hasPathSum2(root.right, sum - root.val)){
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        TreeNode node5 = new TreeNode(5);
        TreeNode node4 = new TreeNode(4);
        TreeNode node8 = new TreeNode(8);
        TreeNode node11 = new TreeNode(11);
        TreeNode node13 = new TreeNode(13);
        TreeNode node44 = new TreeNode(4);
        TreeNode node7 = new TreeNode(7);
        TreeNode node2 = new TreeNode(2);
        TreeNode node1 = new TreeNode(1);

        node5.left = node4;
        node5.right = node8;
        node4.left = node11;
        node8.left = node13;
        node8.right = node44;
        node11.left = node7;
        node11.right = node2;
        node44.right = node1;

        System.out.println(hasPathSum2(node5, 22));
    }
}
