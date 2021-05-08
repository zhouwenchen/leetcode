package com.sh.study.exercise.every.four;

import com.sh.study.node.TreeNode;
import com.sh.study.util.NodeUtil;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;

/**
 * 897. 递增顺序搜索树
 * 给你一棵二叉搜索树，请你 按中序遍历 将其重新排列为一棵递增顺序搜索树，使树中最左边的节点成为树的根节点，并且每个节点没有左子节点，只有一个右子节点。
 *
 *
 *
 * 示例 1：
 *
 *
 * 输入：root = [5,3,6,2,4,null,8,1,null,null,null,7,9]
 * 输出：[1,null,2,null,3,null,4,null,5,null,6,null,7,null,8,null,9]
 * 示例 2：
 *
 *
 * 输入：root = [5,1,7]
 * 输出：[1,null,5,null,7]
 *
 * @author zhouwenchen
 * @date 2021/4/25 19:21
 **/
public class IncreasingBST {
    private static TreeNode resNode;
    public static TreeNode increasingBST(TreeNode root) {
        if(root == null){
            return null;
        }

        TreeNode dumy = new TreeNode(-1);
        resNode = dumy;
        insort(root);

        return dumy.right;
    }

    private static void insort(TreeNode node) {
        if(node == null){
            return;
        }
        insort(node.left);

        // 中序遍历的过程中修改节点指向

        resNode.right = node;
        node.left = null;
        resNode = node;

        insort(node.right);
    }

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        TreeNode node6 = new TreeNode(6);
        TreeNode node7 = new TreeNode(7);
        TreeNode node8 = new TreeNode(8);
        TreeNode node9 = new TreeNode(9);

        node5.left = node3;
        node5.right = node6;
        node3.left = node2;
        node3.right = node4;
        node2.left = node1;
        node6.right = node8;
        node8.left = node7;
        node8.right = node9;

        TreeNode head = increasingBST(node5);
        NodeUtil.printTreeNodeByLevelOrder(head);
    }
}
