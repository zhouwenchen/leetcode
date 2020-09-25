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

    /**
     * 106. 从中序与后序遍历序列构造二叉树
     * 根据一棵树的中序遍历与后序遍历构造二叉树。
     *
     * 注意:
     * 你可以假设树中没有重复的元素。
     *
     * 例如，给出
     *
     * 中序遍历 inorder = [9,3,15,20,7]
     * 后序遍历 postorder = [9,15,7,20,3]
     * 返回如下的二叉树：
     *
     *     3
     *    / \
     *   9  20
     *     /  \
     *    15   7
     *
     * @param inorder 中序遍历 inorder = [9,3,15,20,7]
     * @param postorder 后续遍历 postorder = [9,15,7,20,3]
     * @return
     */
    public static TreeNode buildTree1(int[] inorder, int[] postorder) {
        int n = postorder.length;
        // 构造hash映射，帮助我们快速定位到根节点,中序遍历中的值和对应的下标位置 <value,index>
        indexMap = new HashMap<>();
        for(int i = 0; i < n; i++){
            indexMap.put(inorder[i],i);
        }
        return MybuildTree1(inorder,postorder,0, n-1, 0,n-1);
    }

    private static TreeNode MybuildTree1(int[] inorder, int[] postorder,int postorder_left, int postorder_right, int inorder_left, int inorder_right) {
        if(postorder_left > postorder_right){
            return null;
        }
        // 后续遍历最后一个是根节点 的值  postorder = [9,15,7,20,3]  此时值是  postorder_root_val = 3   postorder_right = 4
        int postorder_root_val = postorder[postorder_right];
        // 中序遍历中根节点的位置 1  postorder_root_val = 3 此时表示的是查找 中序遍历中的父节点 索引位置   root_loc = 1
        Integer root_loc = indexMap.get(postorder_root_val);
        TreeNode root = new TreeNode(postorder_root_val); // 创建根节点  root = 3;

        int inLeftNum=root_loc - inorder_left;  // 左节点的数量

        // 遍历左右子节点
        root.left = MybuildTree1(inorder,postorder,postorder_left,postorder_left + inLeftNum -1,inorder_left,root_loc);
        root.right = MybuildTree1(inorder,postorder,postorder_left + inLeftNum,postorder_right-1,root_loc+1,inorder_right);

        return root;
    }

    public static void main(String[] args) {
//        int[] preorder = new int[]{3,9,20,15,7};
//        int[] inorder = new int[]{9,3,15,20,7};
//        TreeNode root = buildTree(preorder, inorder);
//
        int[] postorder = new int[]{9,15,7,20,3};
        int[] inorder = new int[]{9,3,15,20,7};
        TreeNode root = buildTree1(inorder, postorder);
        System.out.println(root.val);
    }
}
