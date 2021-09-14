package com.sh.study.offer;

import com.sh.study.node.TreeNode;
import com.sh.study.util.NodeUtil;

/**
 * 剑指 Offer 27. 二叉树的镜像
 * 请完成一个函数，输入一个二叉树，该函数输出它的镜像。
 *
 * 例如输入：
 *
 *      4
 *    /   \
 *   2     7
 *  / \   / \
 * 1   3 6   9
 * 镜像输出：
 *
 *      4
 *    /   \
 *   7     2
 *  / \   / \
 * 9   6 3   1
 *
 *
 *
 * 示例 1：
 *
 * 输入：root = [4,2,7,1,3,6,9]
 * 输出：[4,7,2,9,6,3,1]
 *
 * @author zhouwenchen
 * @date 2021/9/13 14:05
 **/
public class MirrorTree {

    public static TreeNode mirrorTree(TreeNode root) {
        if(root == null){
            return null;
        }

        TreeNode left = mirrorTree(root.left);
        TreeNode right = mirrorTree(root.right);
        root.left = right;
        root.right = left;

        return root;
    }

    public static void main(String[] args) {
        TreeNode result = mirrorTree(NodeUtil.createTreeNodeByArr(new int[]{4, 2, 7, 1, 3, 6, 9}));
        NodeUtil.printTreeNodeByLevelOrder(result);
    }
}
