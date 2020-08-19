package com.sh.study.tree;

import com.sh.study.node.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * 105. 从前序与中序遍历序列构造二叉树
 * 根据一棵树的前序遍历与中序遍历构造二叉树。
 *
 * 注意:
 * 你可以假设树中没有重复的元素。
 *
 * 例如，给出
 *
 * 前序遍历 preorder = [3,9,20,15,7]
 * 中序遍历 inorder = [9,3,15,20,7]
 * 返回如下的二叉树：
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 *
 * @Author zhouwenchen
 * @Data 2020/8/18/17
 **/
public class BuildTree {

    private static Map<Integer,Integer> indexMap;

    /**
     * 思路：
     * 1：前序遍历的第一个节点就是根节点
     * 2：第一个节点，在第二个节点的索引位置，在中序遍历中，根节点左边的，就是左子树，根节点右边的，就是右子树
     * 使用递归实现操作
     * 1：定位一个hash映射，快速定位根节点
     *
     * @param preorder
     * @param inorder
     * @return
     */
    public static TreeNode buildTree(int[] preorder, int[] inorder) {
        int n = preorder.length;
        // 构造hash映射，帮助我们快速定位到根节点,中序遍历中的值和对应的下标位置 <value,index>
        indexMap = new HashMap<>();
        for(int i = 0; i < n; i++){
            indexMap.put(inorder[i],i);
        }
        return mybuildTree(preorder,inorder,0,n-1,0,n-1);
    }

    /**
     * 递归调用此方法
     * @param preorder
     * @param inorder
     * @param preorder_left
     * @param preorder_right
     * @param inorder_left
     * @param inorder_right
     * @return
     */
    private static TreeNode mybuildTree(int[] preorder, int[] inorder, int preorder_left, int preorder_right, int inorder_left, int inorder_right) {
        if(preorder_left > preorder_right){
            return null;
        }
        // 前序遍历的第一个元素就是根节点
        int preorder_root = preorder_left;
        // 在中序遍历中，获取到根节点的位置
        int inorder_root = indexMap.get(preorder[preorder_root]);
        // 创建根节点
        TreeNode root = new TreeNode(preorder[preorder_root]);
        // 得到左子树的节点的个数
        int size_left_subtree = inorder_root - inorder_left;
        // 递归的调用左子树，并连接到根节点上去
        root.left = mybuildTree(preorder, inorder, preorder_left + 1, preorder_left + size_left_subtree, inorder_left, inorder_root - 1);
        // 递归地构造右子树，并连接到根节点
        // 先序遍历中「从 左边界+1+左子树节点数目 开始到 右边界」的元素就对应了中序遍历中「从 根节点定位+1 到 右边界」的元素
        root.right = mybuildTree(preorder, inorder, preorder_left + size_left_subtree + 1, preorder_right, inorder_root + 1, inorder_right);
        return root;
    }

    public static void main(String[] args) {
        int[] preorder = new int[]{3,9,20,15,7};
        int[] inorder = new int[]{9,3,15,20,7};
        TreeNode root = buildTree(preorder, inorder);
        System.out.println(root.val);
    }
}
