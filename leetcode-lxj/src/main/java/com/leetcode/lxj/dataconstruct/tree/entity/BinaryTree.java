package com.leetcode.lxj.dataconstruct.tree.entity;

import java.util.LinkedList;

public class BinaryTree<T> {
    private TreeNode<T> rootNode = null;

    /**
     * 层序创建二叉树
     * @param arr
     */
    public BinaryTree(T[] arr) {
        if (null == arr) {
            return;
        }
        rootNode = new TreeNode<>(arr[0]);
        LinkedList<TreeNode<T>> queue = new LinkedList<>();
        queue.offer(rootNode);
        int i = 1;
        T value;
        TreeNode<T> current = null;
        while (i < arr.length) {
            current = queue.poll();
            value = arr[i++];
            if (value != null) {
                TreeNode<T> left = new TreeNode<>(value);
                current.left = left;
                queue.offer(left);
            }
            value = arr[i++];
            if (value != null) {
                TreeNode<T> right = new TreeNode<>(value);
                current.right = right;
                queue.offer(right);
            }
        }
    }

    public TreeNode<T> getRootNode() {
        return rootNode;
    }
}
