package com.sh.study.tree;

import com.sh.study.node.TreeNode;
import com.sun.xml.internal.bind.v2.TODO;

/**
 * 二叉查找树的查找、插入操作
 *
 * <p>
 * *       5
 * *     /   \
 * *    3     7
 * *   / \   /  \
 * *  2  4  6    8
 *
 * @author zhouwenchen
 * @date 2020-08-16 08-41
 */
public class BinarySearchTree {

    /**
     * 二叉树的查找操作
     *
     * @param target 目标节点
     * @return
     */
    public static TreeNode binarySearchTree(TreeNode root, int target) {
        if (root == null) {
            return null;
        }
        TreeNode cur = root;
        while (cur != null) {
            if (target < cur.val) {
                cur = cur.left;
            } else if (target > cur.val) {
                cur = cur.right;
            } else {
                return cur;
            }
        }
        return null;
    }

    /**
     * 二叉查找树的插入操作
     * 1：如果要插入的数据 target 比 root 节点数据大，而且节点数据的右节点为null，直接插入到 root 的右节点
     * 2：如果 root 的右节点 不为null，就需要遍历右子树，寻找到插入的位置
     *
     * 3：如果插入的数据  target 小于 root，并且root的左子节点为 null，那么就直接插入到root的左节点位置
     * 4：如果插入的数据  target 小于 root，并且 root 的左子节点不为 null，需要遍历root的左子节点，查找需要插入的位置信息
     *
     * @param root
     * @param target
     */
    public static void insertbinarySearchTree(TreeNode root, int target) {
        if (root == null) {
            root = new TreeNode(target);
            return;
        }
        TreeNode cur = root;
        while (cur != null){
            if(cur.val < target){
                if(cur.right == null){
                    cur.right = new TreeNode(target);
                    return;
                }
                cur = cur.right;
            } else {
                // 此时 target 小于 root 的节点数据
                if(cur.left == null){
                    cur.left = new TreeNode(target);
                    return;
                }else{
                    cur = cur.left;
                }
            }
        }
    }

    /**
     * 二叉查找树的删除操作，包含三种情况
     * 1：如果要删除节点没有左右子节点，只需要将当前节点的父节点指向当前节点置位 null 即可
     * 2：如果要删除节点有一个左节点或者是右节点的情况，只需要更新父节点，将父节点的下一个节点指针指向要删除节点的子节点即可
     * 3：如果删除节点有左右子节点的情况，就需要将当前需要删除的节点的位置，用右子树的最小值替换即可。
     *
     * TODO 这个删除还是有问题的
     *
     * @param root
     * @param target
     */
    public static void deletebinarySearchTree(TreeNode root,int target){
        if(root == null){
            return ;
        }
        // 1：需要先找到需要删除节点的位置信息
        TreeNode cur = root;
        TreeNode parent = root;
//        TreeNode targetNode = new TreeNode(target);

        while (cur != null && cur.val != target){
            parent = cur;
            if(target > cur.val){
                cur = cur.right;
            }else {
                cur = cur.left;
            }
        }
        if(cur == null){
            // 表示没有找到需要删除的节点
            return;
        }
        // 1：情况3： 需要删除的节点有两个子节点信息,需要查找到右节点的最小值
        if(cur.left != null && cur.right != null){
            TreeNode rightMinTreeNode = cur.right;
            TreeNode parentMinTreeNode = cur;
            while (rightMinTreeNode.left != null){
                parentMinTreeNode = rightMinTreeNode;
                rightMinTreeNode = rightMinTreeNode.left;
            }
            // 替换
            /**
             * TODO 我觉得这边可能还有多种情况
             * 此时需要查找到的是删除节点右节点的最小值。
             * 1：那么最小值节点可能是叶子节点：那么直接替换到 cur.val = rightMinTreeNode.val;并将其其父节点指向  rightMinTreeNode 置为 null。
             * 2：最小值不是叶子节点，有右子节点，那么  cur.val = rightMinTreeNode.val;需要将 rightMinTreeNode 的右子节点替换到当前 rightMinTreeNode 的位置即可。
             */
            cur.val = rightMinTreeNode.val;
            cur = rightMinTreeNode;
//            parent = parentMinTreeNode;
            parentMinTreeNode.right = null;
            return;
        }

        // 2:情况2：删除节点是叶子节点或者仅有一个节点
        if(cur.left != null){
            cur = cur.left;
        } else if(cur.right != null){
            cur = cur.right;
        } else if(cur.val < parent.val){
            parent.left = null;
        }else if(cur.val > parent.val){
            parent.right = null;
        }

        // 3:情况1：删除的是根节点，只需要父节点指向当前节点的置位 null
        if(parent == null){
            return;
        } else if(parent.left == cur){
            parent.left = cur;
        } else if(parent.right == cur){
            parent.right = cur;
        }
    }

    public static void main(String[] args) {
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        TreeNode node6 = new TreeNode(6);
        TreeNode node7 = new TreeNode(7);
        TreeNode node8 = new TreeNode(8);

        node5.left = node3;
        node5.right = node7;
        node3.left = node2;
        node3.right = node4;
        node7.left = node6;
        node7.right = node8;

//        TreeNode result = binarySearchTree(node5, 9);
//        System.out.println(result.val);

//        insertbinarySearchTree(node5, 9);
//        insertbinarySearchTree(node5, 9);

        deletebinarySearchTree(node5,8);
//        deletebinarySearchTree(node5,7);
//        deletebinarySearchTree(node5,6);
        System.out.println(node5);
    }
}
