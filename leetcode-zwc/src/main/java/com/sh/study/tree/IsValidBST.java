package com.sh.study.tree;

import com.sh.study.node.TreeNode;
import com.sh.study.util.NodeUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

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
     * 中序遍历，然后比较每次的元素是否是递增的
     * @param root
     * @return
     */
    public static boolean isValidBST(TreeNode root) {
        if(root == null){
            return true;
        }

        // 中序遍历，如果满足单调性，则返回true
        Stack<TreeNode> stack = new Stack<>();
        List<Integer> values = new ArrayList<>();

        while (!stack.isEmpty() || root != null){
            while (root != null){
                stack.push(root);
                root = root.left;
            }
            root = stack.peek();
            if(!values.isEmpty() && root.val <= values.get(values.size()-1)){
                return false;
            }
            values.add(root.val);
            stack.pop();
            root = root.right;
        }
        return true;
    }

    /**
     * 如果使用的是后序遍历的话，又该如何操作呢 ?
     * TODO
     * @date 20210321
     * @param root
     * @return
     */
    public boolean isValidBST1(TreeNode root) {

        return true;
    }

    public static void main(String[] args) {
//        TreeNode head = NodeUtil.createTreeNodeByArr(new int[]{1, 2, 3});
//        TreeNode head = NodeUtil.createTreeNodeByArr(new int[]{2, 1, 3});
        TreeNode head = NodeUtil.createTreeNodeByArr(new int[]{1, 1});
        System.out.println(isValidBST(head));

        TreeNode node5 = new TreeNode(5);
        TreeNode node4 = new TreeNode(4);
        TreeNode node6 = new TreeNode(6);
        TreeNode node3 = new TreeNode(3);
        TreeNode node7 = new TreeNode(7);
        node5.left = node4;
        node5.right = node6;
        node6.left = node3;
        node6.right = node7;

        System.out.println(isValidBST(node5));
    }
}
