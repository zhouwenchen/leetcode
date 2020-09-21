package com.sh.study.tree;

import com.sh.study.node.TreeNode;
import com.sh.study.util.NodeUtil;
import sun.reflect.generics.tree.Tree;

import java.util.*;

/**
 * 538. 把二叉搜索树转换为累加树
 * 给定一个二叉搜索树（Binary Search Tree），把它转换成为累加树（Greater Tree)，使得每个节点的值是原来的节点值加上所有大于它的节点值之和。
 *
 *
 *
 * 例如：
 *
 * 输入: 原始二叉搜索树:
 *               5
 *             /   \
 *            2     13
 *
 * 输出: 转换为累加树:
 *              18
 *             /   \
 *           20     13
 *
 * @Author zhouwenchen
 * @Date  2020-09-21
 **/
public class ConvertBST {

    /**
     * 解决方法一：暴力法
     * @param root
     * @return
     */
    public static TreeNode convertBST(TreeNode root) {
        if(root == null){
            return root;
        }

        // 二叉树先遍历所有的值
        Map<Integer,Integer> map = new HashMap<>();
        List<Integer> list = BSTtravel(root,map);

        // 以上获取了所有的值并排好序
        Collections.sort(list);

        // 1再次遍历节点，并将获取到的值添加树节点中
        // 2先生成值，之后再重新生成树结构,从后向前遍历

        int sum = 0;
        for (int i = list.size()-1; i >= 0;i--){
            sum += list.get(i);
            map.put(list.get(i),sum);
        }
        BSTtravel(root,map);

        return root;
    }

    private static List<Integer> BSTtravel(TreeNode root,Map<Integer,Integer> map) {
        Deque<TreeNode> stack = new ArrayDeque<TreeNode>();
        stack.push(root);
        List<Integer> list = new ArrayList<>();
        while (!stack.isEmpty()){
            TreeNode node = stack.poll();
            if(map != null && map.size() != 0){
                node.val = map.get(node.val);
            }
            list.add(node.val);
            if(node.left != null){
                stack.add(node.left);
            }
            if(node.right != null){
                stack.add(node.right);
            }
        }
        return list;
    }

    /**
     * 二叉搜索树是排序树，排序树也就是说，前序遍历是从小到大的排序
     * 那么后续遍历，不就是从大到小了嘛，然后累计最大的值不就可以了嘛， 和第一种方法中list排好序，从后遍历不是一个道理的嘛
     * @param root
     * @return
     */
    static int sum = 0;
    public static TreeNode convertBST1(TreeNode root) {
        if(root != null){
            // 遍历右子树
            convertBST1(root.right);
            // 遍历顶点
            sum += root.val;
            root.val = sum;
            // 遍历左子树
            convertBST1(root.left);
            return root;
        }
        return root;
    }


    public static void main(String[] args) {
        TreeNode root = NodeUtil.createTreeNodeByArr(new int[]{5, 2, 13});
//        TreeNode treeNode = convertBST(root);
        TreeNode treeNode = convertBST1(root);
        System.out.println(treeNode);
    }
}
