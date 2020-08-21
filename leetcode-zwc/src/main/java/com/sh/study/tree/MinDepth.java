package com.sh.study.tree;

import com.sh.study.node.ListNode;
import com.sh.study.node.TreeNode;
import com.sh.study.util.NodeUtil;
import javafx.scene.layout.Priority;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;

/**
 * 111. 二叉树的最小深度
 * 给定一个二叉树，找出其最小深度。
 *
 * 最小深度是从根节点到最近叶子节点的最短路径上的节点数量。
 *
 * 说明: 叶子节点是指没有子节点的节点。
 *
 * 示例:
 *
 * 给定二叉树 [3,9,20,null,null,15,7],
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回它的最小深度  2.
 *
 * @Author zhouwenchen
 * @Data 2020/8/21/15
 **/
public class MinDepth {
    /**
     * 叶子节点的定义是左孩子和右孩子都为 null 时叫做叶子节点
     * 当 root 节点左右孩子都为空时，返回 1
     * 当 root 节点左右孩子有一个为空时，返回不为空的孩子节点的深度
     * 当 root 节点左右孩子都不为空时，返回左右孩子较小深度的节点值
     *
     * @param root
     * @return
     */
    public static int minDepth(TreeNode root) {
        if(root == null){
            return 0;
        }
        int depth = 0;
        // 左孩子和右孩子都为 空的情况下，返回1
        if(root.left == null&& root.right == null ){
            return 1;
        }
        // 左孩子和右孩子，有一个为空的情况下，需要返回最小值
        int left = minDepth(root.left);
        int right = minDepth(root.right);
        //这里其中一个节点为空，说明m1和m2有一个必然为0，所以可以返回m1 + m2 + 1;
        if(root.left == null || root.right == null) {
            return left + right + 1;
        }

        return Math.min(left,right) + 1;
    }

    public static void main(String[] args) {
        // 此处的 -1 表示 是 null
        TreeNode root = NodeUtil.createTreeNodeByArr(new int[]{3, 9, 20, -1, -1, 15, 7});
//        TreeNode root = NodeUtil.createTreeNodeByArr(new int[]{1,-1,2});
//        TreeNode root = NodeUtil.createTreeNodeByArr(new int[]{1,2});
        NodeUtil.printTreeNodeByLevelOrder(root);
        int depth = minDepth(root);
        System.out.println(depth);
    }
}
