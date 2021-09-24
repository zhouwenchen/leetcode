package com.sh.study.offer;

import com.sh.study.node.TreeNode;
import com.sh.study.util.NodeUtil;

import java.util.stream.IntStream;

/**
 * 剑指 Offer 55 - II. 平衡二叉树
 * 输入一棵二叉树的根节点，判断该树是不是平衡二叉树。如果某二叉树中任意节点的左右子树的深度相差不超过1，那么它就是一棵平衡二叉树。
 *
 *
 *
 * 示例 1:
 *
 * 给定二叉树 [3,9,20,null,null,15,7]
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回 true 。
 *
 * 示例 2:
 *
 * 给定二叉树 [1,2,2,3,3,null,null,4,4]
 *
 *        1
 *       / \
 *      2   2
 *     / \
 *    3   3
 *   / \
 *  4   4
 * 返回 false 。
 *
 * @author zhouwenchen
 * @date 2021/9/23 14:37
 **/
public class IsBalanced {

    public static boolean isBalanced(TreeNode root) {
        if(root == null){
            return true;
        }
        return Math.abs(height(root.left)-height(root.right))<=1 && isBalanced(root.left) && isBalanced(root.right);
    }

    /**
     * 获取二叉树的高度值
     * @param root
     * @return
     */
    public static int height(TreeNode root){
        if(root == null){
            return 0;
        }else {
            return Math.max(height(root.left),height(root.right))+1;
        }
    }

    public static void main(String[] args) {
        TreeNode root = NodeUtil.createTreeNodeByArr(new int[]{3, 9, 20, -1, -1, 15, 7});
        System.out.println(isBalanced(root));
    }
}
