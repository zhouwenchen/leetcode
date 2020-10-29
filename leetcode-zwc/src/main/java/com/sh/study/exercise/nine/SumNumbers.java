package com.sh.study.exercise.nine;


import com.sh.study.node.TreeNode;
import com.sh.study.util.NodeUtil;

import java.util.*;

/**
 * 129. 求根到叶子节点数字之和
 * 给定一个二叉树，它的每个结点都存放一个 0-9 的数字，每条从根到叶子节点的路径都代表一个数字。
 *
 * 例如，从根到叶子节点路径 1->2->3 代表数字 123。
 *
 * 计算从根到叶子节点生成的所有数字之和。
 *
 * 说明: 叶子节点是指没有子节点的节点。
 *
 * 示例 1:
 *
 * 输入: [1,2,3]
 *     1
 *    / \
 *   2   3
 * 输出: 25
 * 解释:
 * 从根到叶子节点路径 1->2 代表数字 12.
 * 从根到叶子节点路径 1->3 代表数字 13.
 * 因此，数字总和 = 12 + 13 = 25.
 * 示例 2:
 *
 * 输入: [4,9,0,5,1]
 *     4
 *    / \
 *   9   0
 *  / \
 * 5   1
 * 输出: 1026
 * 解释:
 * 从根到叶子节点路径 4->9->5 代表数字 495.
 * 从根到叶子节点路径 4->9->1 代表数字 491.
 * 从根到叶子节点路径 4->0 代表数字 40.
 * 因此，数字总和 = 495 + 491 + 40 = 1026.
 *
 * @Author zhouwenchen
 * @Data 2020/10/29/09
 **/
public class SumNumbers {

    /**
     *
     *
     * @param root
     * @return
     */
    public static int sumNumbers(TreeNode root) {
        if(root == null){
            return 0;
        }
        Deque<TreeNode> nodeDeque = new ArrayDeque<>();
        Deque<Integer> numDeque = new ArrayDeque<>();
        nodeDeque.offer(root);
        numDeque.offer(root.val);
        int sum = 0;
        while (!nodeDeque.isEmpty()){
            TreeNode node = nodeDeque.poll();
            int num = numDeque.poll();
            TreeNode left = node.left;
            TreeNode right = node.right;
            if(left == null && right == null){
                sum += num;
            } else {
                if(left != null){
                    nodeDeque.offer(left);
                    numDeque.offer(num * 10 + left.val);
                }
                if(right != null){
                    nodeDeque.offer(right);
                    numDeque.offer(num * 10 + right.val);
                }
            }
        }
        return sum;
    }

    /**
     * 深度优先遍历 dfs
     *
     * @param root
     * @return
     */
    public static int sumNumbers1(TreeNode root) {
        return dfs(root,0);
    }

    private static int dfs(TreeNode root, int preNum) {
        if(root == null){
            return 0;
        }
        int sum = preNum * 10 + root.val;
        if(root.left == null && root.right == null){
            return sum;
        } else{
            return dfs(root.left, sum) + dfs(root.right,sum);
        }

    }


    public static void main(String[] args) {
        TreeNode root = NodeUtil.createTreeNodeByArr(new int[]{1, 2, 3});
        System.out.println(sumNumbers1(root));
    }
}
