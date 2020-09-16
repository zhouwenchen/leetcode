package com.sh.study.binarytree;

import com.sh.study.node.TreeNode;
import com.sh.study.queue.ArrayQueue;
import com.sh.study.util.NodeUtil;
import sun.plugin.javascript.navig.Array;

import java.util.*;
import java.util.concurrent.DelayQueue;

/**
 * 226. 翻转二叉树
 * 翻转一棵二叉树。
 *
 * 示例：
 *
 * 输入：
 *
 *      4
 *    /   \
 *   2     7
 *  / \   / \
 * 1   3 6   9
 * 输出：
 *
 *      4
 *    /   \
 *   7     2
 *  / \   / \
 * 9   6 3   1
 *
 * @Author zhouwenchen
 * @Date  2020-09-16
 **/
public class InvertTree {

    /**
     * 使用递归实现操作
     * @param root
     * @return
     */
    public static TreeNode invertTree(TreeNode root) {
        if(root == null){
            return root;
        }
        TreeNode temp =root.left;
        root.left = root.right;
        root.right = temp;

        invertTree(root.left);
        invertTree(root.right);
        return root;
    }

    /**
     * 一个一个遍历节点，重新生成翻转二叉树
     * @param root
     * @return
     */
    public static TreeNode invertTree1(TreeNode root){
        if(root == null){
            return root;
        }
        Deque<TreeNode> deque = new ArrayDeque();
        deque.add(root);
        while (!deque.isEmpty()){
            TreeNode node = deque.pop();
            TreeNode tempLeft = node.left;
            node.left = node.right;
            node.right = tempLeft;

            if(node.left != null){
                deque.push(node.left);
            }
            if(node.right != null){
                deque.push(node.right);
            }
        }
       return root;
    }

    public static void main(String[] args) {
//        TreeNode treeNode = NodeUtil.createTreeNodeByArr(new int[]{4, 2, 7, 1, 3, 6, 9});
//        TreeNode treeNode1 = invertTree(treeNode);

        TreeNode treeNode = NodeUtil.createTreeNodeByArr(new int[]{4, 2, 7, 1, 3, 6, 9});
//        TreeNode node1 = new TreeNode(1);
//        TreeNode node2 = new TreeNode(2);
//        node1.right = node2;
        TreeNode treeNode1 = invertTree1(treeNode);
        System.out.println(treeNode1);
    }
}
