package com.sh.study.exercise.eight;

import com.sh.study.node.TreeNode;
import com.sh.study.util.NodeUtil;

/**
 * 701. 二叉搜索树中的插入操作
 * 给定二叉搜索树（BST）的根节点和要插入树中的值，将值插入二叉搜索树。 返回插入后二叉搜索树的根节点。 输入数据保证，新值和原始二叉搜索树中的任意节点值都不同。
 *
 * 注意，可能存在多种有效的插入方式，只要树在插入后仍保持为二叉搜索树即可。 你可以返回任意有效的结果。
 *
 *
 *
 * 例如,
 *
 * 给定二叉搜索树:
 *
 *         4
 *        / \
 *       2   7
 *      / \
 *     1   3
 *
 * 和 插入的值: 5
 * 你可以返回这个二叉搜索树:
 *
 *          4
 *        /   \
 *       2     7
 *      / \   /
 *     1   3 5
 * 或者这个树也是有效的:
 *
 *          5
 *        /   \
 *       2     7
 *      / \
 *     1   3
 *          \
 *           4
 *
 *
 * 提示：
 *
 * 给定的树上的节点数介于 0 和 10^4 之间
 * 每个节点都有一个唯一整数值，取值范围从 0 到 10^8
 * -10^8 <= val <= 10^8
 * 新值和原始二叉搜索树中的任意节点值都不同
 * @Author zhouwenchen
 * @Date  2020-09-30
 **/
public class InsertIntoBST {

    /**
     * @param root
     * @param val
     * @return
     */
    public static TreeNode insertIntoBST(TreeNode root, int val) {
        TreeNode node = new TreeNode(val);
        if(root == null){
            return node;
        }
        node = root;
        // 有左子树 或者 有右子树
        while (node != null) {
            if (node.val < val) {
                if (node.right == null) {
                    node.right = new TreeNode(val);
                    break;
                } else{
                    node = node.right;
                }
            } else  if(node.val > val) {
                if (node.left == null) {
                    node.left = new TreeNode(val);
                    break;
                } else {
                    node = node.left;
                }
            }
        }
        return root;
    }

    public static void main(String[] args) {
//        TreeNode root = NodeUtil.createTreeNodeByArr(new int[]{1, 2, 3, 4, 5, 6});
//        int val = 7;

//        TreeNode root = NodeUtil.createTreeNodeByArr(new int[]{1, 2, 3, 4, 5});
//        int val = 7;
        /**
         * [55,28,92,26,43,null,null,null,null,null,null]
         * 1
         * 预期结果
         * [55,28,92,26,43,null,null,1]
         *
         */
        TreeNode node55 = new TreeNode(55);
        TreeNode node28 = new TreeNode(28);
        TreeNode node92 = new TreeNode(92);
        TreeNode node26 = new TreeNode(26);
        TreeNode node43 = new TreeNode(43);

        node55.left = node28;
        node55.right = node92;
        node28.left = node26;
        node28.right = node43;
        int val = 1;
        TreeNode resultNode = insertIntoBST(node55, val);

        /**
         * 1：特殊测试案例
         */
//        [8,null,55,39,null,11,null,null,23,null,null]
//        17
//        [8,null,55,39,null,11,null,null,23,17]
        /**
         * 2：特殊测试案例
         */
//        [5,null,14,10,77,null,null,null,95,null,null]
//        4
//        [5,4,14,null,null,10,77,null,null,null,95]

        // 层序遍历
        NodeUtil.printTreeNodeByLevelOrder(resultNode);
    }
}
