package com.sh.study.tree;

import com.sh.study.node.TreeNode;
import com.sh.study.util.NodeUtil;

/**
 * 98. 验证二叉搜索树
 * 给定一个二叉树，判断其是否是一个有效的二叉搜索树。
 *
 * 假设一个二叉搜索树具有如下特征：
 *
 * 节点的左子树只包含小于当前节点的数。
 * 节点的右子树只包含大于当前节点的数。
 * 所有左子树和右子树自身必须也是二叉搜索树。
 * 示例 1:
 *
 * 输入:
 *     2
 *    / \
 *   1   3
 * 输出: true
 * 示例 2:
 *
 * 输入:
 *     5
 *    / \
 *   1   4
 *      / \
 *     3   6
 * 输出: false
 * 解释: 输入为: [5,1,4,null,null,3,6]。
 *      根节点的值为 5 ，但是其右子节点值为 4 。
 *
 * @author zhouwenchen
 * @date 2021/3/26 18:06
 **/
public class IsValidBST {
    /**
     *
     * @param root
     * @return
     */
    public static boolean isValidBST(TreeNode root) {
        return true;
    }

    public static void main(String[] args) {
        TreeNode head = NodeUtil.createTreeNodeByArr(new int[]{1, 2, 3});
        System.out.println(isValidBST(head));
    }
}
