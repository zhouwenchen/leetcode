package com.sh.study.exercise.three;

import com.sh.study.node.TreeNode;

import java.util.*;

/**
 * 剑指 Offer 68 - II. 二叉树的最近公共祖先
 * 给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。
 *
 * 百度百科中最近公共祖先的定义为：“对于有根树 T 的两个结点 p、q，最近公共祖先表示为一个结点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”
 *
 * 例如，给定如下二叉树:  root = [3,5,1,6,2,0,8,null,null,7,4]
 *
 *
 *		     3
 * 	    5		     1
 *   6	   2	   0	8
 * 	    7     4
 *
 *
 * 示例 1:
 *
 * 输入: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
 * 输出: 3
 * 解释: 节点 5 和节点 1 的最近公共祖先是节点 3。
 * 示例 2:
 *
 * 输入: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 4
 * 输出: 5
 * 解释: 节点 5 和节点 4 的最近公共祖先是节点 5。因为根据定义最近公共祖先节点可以为节点本身。
 *
 *
 * 说明:
 *
 * 所有节点的值都是唯一的。
 * p、q 为不同节点且均存在于给定的二叉树中。
 * 注意：本题与主站 236 题相同：https://leetcode-cn.com/problems/lowest-common-ancestor-of-a-binary-tree/
 * @Author zhouwenchen
 * @Data 2020/8/18/15
 **/
public class LowestCommonAncestor {

    /**
     * 使用递归实现查找 两个节点的最近的公共祖先节点
     * @param root
     * @param p
     * @param q
     * @return
     */
    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }
        if (root.val == p.val || root.val == q.val) {
            return root;
        }
        // 递归调用左右子树的情况
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if (left != null && right != null) {
            return root;
        }
        if (left == null) {
            return right;
        }
        if (right == null) {
            return left;
        }
        return null;
    }

    /**
     *
     * @param root
     * @param p
     * @param q
     * @return
     */
    public static TreeNode lowestCommonAncestor1(TreeNode root, TreeNode p, TreeNode q) {
        // 记录当前节点和父节点
        Map<TreeNode,TreeNode> parent  = new HashMap<>();
        // 遍历二叉树
        Queue<TreeNode> queue = new LinkedList<>();
        parent .put(root, null);
        queue.add(root);
        while (!parent.containsKey(p) || !parent.containsKey(q)){
            TreeNode node = queue.poll();
            if(node.left != null){
                parent.put(node.left, node);
                queue.add(node.left);
            }
            if(node.right != null){
                parent.put(node.right, node);
                queue.add(node.right);
            }
        }

        Set<TreeNode> ancestors = new HashSet<>();
        // 记录下p和他的 所有的 祖先节点，存入到 ancestors 中
        while (p != null){
            ancestors.add(p);
            p = parent.get(p);
        }
        // 查找q的祖先节点是否在 ancestors ，如果存在，表示存在 二叉树的最近公共祖先
        while (!ancestors.contains(q)){
            q = parent.get(q);
        }

        return q;
    }

    /**
     * 如果两个节点值都小于根节点，说明他们都在根节点的左子树上，我们往左子树上找
     * 如果两个节点值都大于根节点，说明他们都在根节点的右子树上，我们往右子树上找
     * 如果一个节点值大于根节点，一个节点值小于根节点，说明他们他们一个在根节点的左子树上一个在根节点的右子树上，那么根节点就是他们的最近公共祖先节点。
     *
     * 剑指 Offer 68 - I. 二叉搜索树的最近公共祖先
     * 给定一个二叉搜索树, 找到该树中两个指定节点的最近公共祖先。
     *
     * 百度百科中最近公共祖先的定义为：“对于有根树 T 的两个结点 p、q，最近公共祖先表示为一个结点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”
     *
     * 例如，给定如下二叉搜索树:  root = [6,2,8,0,4,7,9,null,null,3,5]
     *
     *
     *
     *
     *
     * 示例 1:
     *
     * 输入: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 8
     * 输出: 6
     * 解释: 节点 2 和节点 8 的最近公共祖先是 6。
     * 示例 2:
     *
     * 输入: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 4
     * 输出: 2
     * 解释: 节点 2 和节点 4 的最近公共祖先是 2, 因为根据定义最近公共祖先节点可以为节点本身。
     *
     *
     * 说明:
     *
     * 所有节点的值都是唯一的。
     * p、q 为不同节点且均存在于给定的二叉搜索树中。
     *
     * @param root
     * @param p
     * @param q
     * @return
     */
    public static TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {
        // 根节点减去 p 和 q，相乘的积，如果大于0 ，表示在同一侧
        while ((root.val - p.val) * (root.val -q.val) > 0){
            root = p.val < root.val?root.left:root.right;
        }
       return root;
    }


    public static void main(String[] args) {
        TreeNode node3 = new TreeNode(3);
        TreeNode node5 = new TreeNode(5);
        TreeNode node1 = new TreeNode(1);
        TreeNode node6 = new TreeNode(6);
        TreeNode node2 = new TreeNode(2);
        TreeNode node0 = new TreeNode(0);
        TreeNode node8 = new TreeNode(8);
        TreeNode node7 = new TreeNode(7);
        TreeNode node4 = new TreeNode(4);

        node3.left = node5;
        node3.right = node1;
        node5.left = node6;
        node5.right = node2;
        node1.left = node0;
        node1.right = node8;
        node2.left = node7;
        node2.right = node4;


//        TreeNode root = lowestCommonAncestor(node3, node5, node1);
//        TreeNode root = lowestCommonAncestor1(node3, node5, node1);
        TreeNode root = lowestCommonAncestor2(node3, node5, node1);
        System.out.println("二叉树的最近公共祖先:" + root.val);
    }
}
