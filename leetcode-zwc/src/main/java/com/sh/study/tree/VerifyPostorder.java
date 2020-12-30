package com.sh.study.tree;

import com.sh.study.node.TreeNode;

/**
 * 剑指 Offer 33. 二叉搜索树的后序遍历序列
 * 输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历结果。如果是则返回 true，否则返回 false。假设输入的数组的任意两个数字都互不相同。
 *
 * 参考以下这颗二叉搜索树：
 *
 *      5
 *     / \
 *    2   6
 *   / \
 *  1   3
 * 示例 1：
 *
 * 输入: [1,6,3,2,5]
 * 输出: false
 * 示例 2：
 *
 * 输入: [1,3,2,6,5]
 * 输出: true
 *
 * @Author zhouwenchen
 * @Date
 **/
public class VerifyPostorder {

    /**
     * 相当于根据输入的数组构建一个二叉搜索树（根节点的值大于左节点，小于右节点）
     * 1：根节点：最后一个值一定是根节点
     * 2：左子树：从根节点开始，从后向前遍历，第一个小于根节点的值，假如此时索引是 l，左子树就是[0,l];
     * 3：右子树：从根节点开始，从后向前遍历，第一个大于根节点的值，假如此时索引是 r,那么右子树[l+1,r];
     *
     * TODO 思路对了，但是没有实现出来
     *
     * @param postorder
     * @return
     */
    public static boolean verifyPostorder(int[] postorder) {
        TreeNode head = postorderArr(postorder,0,postorder.length-1);
        return false;
    }

    private static TreeNode postorderArr(int[] postorder,int l,int r) {
        if (postorder == null) {
            return null;
        }
        if (l > r) {
            return null;
        }
        // 查找一个M，
        int m = r;
        for (; m > l; m--) {
            if (postorder[r] > postorder[m - 1]) {
                m--;
            }
        }
        TreeNode head = new TreeNode(postorder[r]);
        head.left = postorderArr(postorder, l, m);
        head.right = postorderArr(postorder, m + 1, r);
        return head;
    }

    /**
     *
     * @param postorder
     * @return
     */
    public static boolean verifyPostorder1(int[] postorder) {
        return helper(postorder, 0, postorder.length - 1);
    }

    private static boolean helper(int[] postorder, int left, int right) {
        // 如果left == right，表示只有一个节点了，此时就不需要判断了，left > right 表示，此时已经没有节点了，也就不需要判断了
        if(left >= right){
            return true;
        }
        // 数组中最后一个节点是根节点，我们从前往后遍历，找出第一个比根节点大的值，此时从该节点开始，后面应该都是大于等于根节点的值（如果有小于的话，说明不是二叉树搜索树）
        // 该节点之前的，都是小于根节点的数，都是根节点的左子树
        int mid = left;
        int rootVal = postorder[right];
        while (postorder[mid] < rootVal){
            mid++;
        }
        int tmp = mid;
        // 判断此时右子树中是否包含小于根节点的值，如果有，该数据就不是二叉搜索树
        while (tmp < right){
            if(postorder[tmp++] < rootVal){
                return false;
            }
        }

        // 因为
        return helper(postorder,left,mid-1) && helper(postorder,mid,right-1);
    }

    public static void main(String[] args) {
        System.out.println(verifyPostorder1(new int[]{1, 3, 2, 6, 5}));
        System.out.println(verifyPostorder1(new int[]{1, 6, 3, 2, 5}));
    }
}
