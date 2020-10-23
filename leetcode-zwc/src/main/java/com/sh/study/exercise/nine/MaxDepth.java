package com.sh.study.exercise.nine;

import com.sh.study.node.TreeNode;
import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 104. 二叉树的最大深度
 * 给定一个二叉树，找出其最大深度。
 *
 * 二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。
 *
 * 说明: 叶子节点是指没有子节点的节点。
 *
 * 示例：
 * 给定二叉树 [3,9,20,null,null,15,7]，
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回它的最大深度 3 。
 *
 * @Author zhouwenchen
 * @Data 2020/10/23/15
 **/
public class MaxDepth {
    /**
     * 层次遍历，获取到栈的深度
     *
     * @param root
     * @return
     */
    public static int maxDepth(TreeNode root) {
        if(root == null){
            return 0;
        }
        Deque<TreeNode> deque = new ArrayDeque<TreeNode>();
        deque.push(root);
        int depth = 0;
        while (!deque.isEmpty()){
            int size = deque.size();
            while (size > 0){
                TreeNode node = deque.poll();
                if(node.left != null){
                    deque.offer(node.left);
                }
                if(node.right != null){
                    deque.offer(node.right);
                }
                size--;
            }
            depth++;
        }
        return depth;
    }

    /**
     * 递归实现,效率很好
     *
     * @param root
     * @return
     */
    public static int maxDepth1(TreeNode root) {
        if(root ==null){
            return 0;
        }
        return Math.max(maxDepth1(root.left), maxDepth1(root.right))+1;
    }

    public static void main(String[] args) {
        TreeNode node3 = new TreeNode(3);
        TreeNode node9 = new TreeNode(9);
        TreeNode node20 = new TreeNode(20);
        TreeNode node15 = new TreeNode(15);
        TreeNode node7 = new TreeNode(7);

        node3.left = node9;
        node3.right = node20;
        node20.left = node15;
        node20.right = node7;

        System.out.println(maxDepth1(node3));
    }
}
