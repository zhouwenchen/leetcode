package com.sh.study.offer;

import com.sh.study.node.TreeNode;
import com.sh.study.util.NodeUtil;

/**
 * 剑指 Offer 26. 树的子结构
 * 输入两棵二叉树A和B，判断B是不是A的子结构。(约定空树不是任意一个树的子结构)
 *
 * B是A的子结构， 即 A中有出现和B相同的结构和节点值。
 *
 * 例如:
 * 给定的树 A:
 *
 *      3
 *     / \
 *    4   5
 *   / \
 *  1   2
 * 给定的树 B：
 *
 *    4
 *   /
 *  1
 * 返回 true，因为 B 与 A 的一个子树拥有相同的结构和节点值。
 *
 * 示例 1：
 *
 * 输入：A = [1,2,3], B = [3,1]
 * 输出：false
 * 示例 2：
 *
 * 输入：A = [3,4,5,1,2], B = [4,1]
 * 输出：true
 * 限制：
 *
 * 0 <= 节点个数 <= 10000
 *
 * @author zhouwenchen
 * @date 2021/9/13 11:27
 **/
public class IsSubStructure {

    /**
     * TODO 好像又没有实现问题
     * @param s
     * @param t
     * @return
     */
    public static boolean isSubStructure(TreeNode s, TreeNode t) {
        return dfs(s,t);
    }

    private static boolean dfs(TreeNode s, TreeNode t) {
        if(s == null){
            return false;
        }
        return check(s,t) || dfs(s.left,t) || dfs(s.right,t);
    }

    private static boolean check(TreeNode s, TreeNode t) {
        if(s == null && t == null){
            return true;
        }
        if(s == null || t == null|| s.val != t.val){
            return false;
        }
        return check(s.left,t.left) && check(s.right,t.right);
    }

    /**
     * 使用递归实现操作，
     *
     * TODO 不是特别明白
     *
     * @param A
     * @param B
     * @return
     */
    public static boolean isSubStructure1(TreeNode A, TreeNode B) {
        return (A != null && B != null) && (recur(A, B) || isSubStructure1(A.left, B) || isSubStructure1(A.right, B));
    }
    static boolean recur(TreeNode A, TreeNode B) {
        if (B == null) return true;
        if (A == null || A.val != B.val) return false;
        return recur(A.left, B.left) && recur(A.right, B.right);
    }

    public static void main(String[] args) {
        TreeNode A = NodeUtil.createTreeNodeByArr(new int[]{3, 4, 5, 1, 2});
        TreeNode B = NodeUtil.createTreeNodeByArr(new int[]{4, 1});
//        System.out.println(isSubStructure(A, B));

        System.out.println(isSubStructure1(A, B));
    }
}
