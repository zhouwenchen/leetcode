package com.sh.study.offer;

import com.sh.study.node.TreeNode;
import com.sh.study.util.NodeUtil;

/**
 * 剑指 Offer 28. 对称的二叉树
 * 请实现一个函数，用来判断一棵二叉树是不是对称的。如果一棵二叉树和它的镜像一样，那么它是对称的。
 *
 * 例如，二叉树 [1,2,2,3,4,4,3] 是对称的。
 *
 *     1
 *    / \
 *   2   2
 *  / \ / \
 * 3  4 4  3
 * 但是下面这个 [1,2,2,null,3,null,3] 则不是镜像对称的:
 *
 *     1
 *    / \
 *   2   2
 *    \   \
 *    3    3
 *
 *
 *
 * 示例 1：
 *
 * 输入：root = [1,2,2,3,4,4,3]
 * 输出：true
 * 示例 2：
 *
 * 输入：root = [1,2,2,null,3,null,3]
 * 输出：false
 *
 *
 * 限制：
 *
 * 0 <= 节点个数 <= 1000
 *
 * 注意：本题与主站 101 题相同：https://leetcode-cn.com/problems/symmetric-tree/
 *
 * @author zhouwenchen
 * @date 2021/9/13 14:22
 **/
public class IsSymmetric {

    public static boolean isSymmetric(TreeNode root) {
        return root == null?true:recur(root.left,root.right);
    }

    private static boolean recur(TreeNode left, TreeNode right) {
        if(left == null && right == null) return true;
        if(left == null || right == null || left.val != right.val) return false;
        return recur(left.left,right.right) && recur(left.right,right.left);
    }

    public static void main(String[] args) {
        System.out.println(isSymmetric(NodeUtil.createTreeNodeByArr(new int[]{1, 2, 2, 3, 4, 4, 3})));
    }
}
