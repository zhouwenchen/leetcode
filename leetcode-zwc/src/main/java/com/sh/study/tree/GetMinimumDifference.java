package com.sh.study.tree;

import com.sh.study.node.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 530. 二叉搜索树的最小绝对差
 * 给你一棵所有节点为非负值的二叉搜索树，请你计算树中任意两节点的差的绝对值的最小值。
 *
 *
 *
 * 示例：
 *
 * 输入：
 *
 *    1
 *     \
 *      3
 *     /
 *    2
 *
 * 输出：
 * 1
 *
 * 解释：
 * 最小绝对差为 1，其中 2 和 1 的差的绝对值为 1（或者 2 和 3）。
 *
 * @Author zhouwenchen
 * @Date  2020-10-12
 **/
public class GetMinimumDifference {

    /**
     * 简单的思路：
     * 1：先遍历二叉排序树（中序遍历），然后排序，相减，取最小值（这个想法就很好，但是效率不行）
     * @param root
     * @return
     */
    public static int getMinimumDifference(TreeNode root) {
        int result = 0;
        if(root == null){
            return result;
        }
        // 先中序遍历,非递归实现
        List<TreeNode> p = new ArrayList<>();
        List<Integer> res =  new ArrayList<>();
        int first = 0;
        int count = 0;
        while (root!= null || p.size() != 0){
            while (root != null){
                p.add(root);
                root = root.left;
            }
            int loc = p.size() - 1;
            root = p.get(loc);
            p.remove(loc);
            // 次数计算两个差值
//            res.add(root.val);
            if(count==1){
                result = root.val - first;
                count++;
            } else {
                result = Math.min(Math.abs(root.val - first),result);
            }
            count++;
            first = root.val;
            root = root.right;
        }
        return result;
    }

    public static void main(String[] args) {
//        TreeNode node1 = new TreeNode(1);
//        TreeNode node2 = new TreeNode(2);
//        TreeNode node3 = new TreeNode(3);
//
//        node1.right = node3;
//        node3.left = node2;

//        TreeNode node5 = new TreeNode(5);
//        TreeNode node4 = new TreeNode(4);
//        TreeNode node7 = new TreeNode(7);
//
//        node5.left = node4;
//        node5.right = node7;

//        [1,null,5,3]
        TreeNode node1 = new TreeNode(1);
        TreeNode node5 = new TreeNode(5);
        TreeNode node3 = new TreeNode(3);

        node1.right = node5;
        node5.left = node3;

        System.out.println(getMinimumDifference(node1));
    }
}
