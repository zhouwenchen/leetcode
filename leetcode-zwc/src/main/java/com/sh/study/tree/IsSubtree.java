package com.sh.study.tree;

import com.sh.study.node.TreeNode;
import com.sh.study.util.NodeUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 572. 另一个树的子树
 * 给定两个非空二叉树 s 和 t，检验 s 中是否包含和 t 具有相同结构和节点值的子树。s 的一个子树包括 s 的一个节点和这个节点的所有子孙。s 也可以看做它自身的一棵子树。
 * <p>
 * 示例 1:
 * 给定的树 s:
 * <p>
 * 3
 * / \
 * 4   5
 * / \
 * 1   2
 * 给定的树 t：
 * <p>
 * 4
 * / \
 * 1   2
 * 返回 true，因为 t 与 s 的一个子树拥有相同的结构和节点值。
 * <p>
 * 示例 2:
 * 给定的树 s：
 * <p>
 * 3
 * / \
 * 4   5
 * / \
 * 1   2
 * /
 * 0
 * 给定的树 t：
 * <p>
 * 4
 * / \
 * 1   2
 * 返回 false。
 *
 * @author zhouwenchen
 * @date 2021/3/29 17:50
 **/
public class IsSubtree {

    /**
     * 前序遍历的同时，判断 s 节点是否等于 t 节点的值
     * TODO 这个没有实现出来
     *
     * @param s
     * @param t
     * @return
     */
    public static boolean isSubtree(TreeNode s, TreeNode t) {
        if (s == null && t == null || t == null) {
            return true;
        }
        Stack<TreeNode> stack1 = new Stack<>();
        Stack<TreeNode> stack2 = new Stack<>();
        List<Integer> values1 = new ArrayList<>();
        List<Integer> values2 = new ArrayList<>();
        boolean flag = true;
        while (!stack1.isEmpty() || s != null) {
            while (s != null || t != null) {
                stack1.push(s);
                values1.add(s.val);
                if (t != null) {
                    stack2.push(t);
                    values2.add(t.val);
                    t = t.left;
                }
                s = s.left;
            }
            s = stack1.peek();
            stack1.pop();
            s = s.right;

            if (stack2 != null && stack2.size() > 0) {
                t = stack2.peek();
                stack2.pop();
                t = t.right;
            }
        }

        return true;
    }

    /**
     * 使用递归实现操作
     *
     * @param s
     * @param t
     * @return
     */
    public static boolean isSubtree1(TreeNode s, TreeNode t) {
        return dfs(s, t);
    }

    private static boolean dfs(TreeNode s, TreeNode t) {
        if (s == null) {
            return false;
        }
        return check(s, t) || dfs(s.left, t) || dfs(s.right, t);
    }

    private static boolean check(TreeNode s, TreeNode t) {
        if (s == null && t == null) {
            return true;
        }
        if (s == null || t == null || s.val != t.val) {
            return false;
        }
        return check(s.left, t.left) && check(s.right, t.right);
    }

    public static void main(String[] args) {
        TreeNode s = NodeUtil.createTreeNodeByArr(new int[]{3, 4, 5, 1, 2});
        TreeNode t = NodeUtil.createTreeNodeByArr(new int[]{4, 1, 2});

        System.out.println(isSubtree(s, t));
    }
}
