package com.sh.study.tree;

import com.sh.study.node.TreeNode;
import com.sh.study.util.NodeUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 100. 相同的树
 * 给你两棵二叉树的根节点 p 和 q ，编写一个函数来检验这两棵树是否相同。
 *
 * 如果两个树在结构上相同，并且节点具有相同的值，则认为它们是相同的。
 *
 *
 *
 * 示例 1：
 *
 *
 * 输入：p = [1,2,3], q = [1,2,3]
 * 输出：true
 * 示例 2：
 *
 *
 * 输入：p = [1,2], q = [1,null,2]
 * 输出：false
 * 示例 3：
 *
 *
 * 输入：p = [1,2,1], q = [1,1,2]
 * 输出：false
 *
 *
 * 提示：
 *
 * 两棵树上的节点数目都在范围 [0, 100] 内
 * -104 <= Node.val <= 104
 * @author zhouwenchen
 * @date 2021/3/29 16:18
 **/
public class IsSameTree {
    // 同时遍历二叉树，不管是前中后遍历方式都可以
    // 这里使用中序遍历，使用栈实现操作
    public static boolean isSameTree(TreeNode p, TreeNode q) {
        if(p == null && q == null){
            return true;
        }
        Stack<TreeNode> stack1 = new Stack<>();
        Stack<TreeNode> stack2 = new Stack<>();
//        List<Integer> values = new ArrayList<>();
        while (!stack1.isEmpty() || p != null && q != null){
            while (p != null || q != null){
                stack1.push(p);
                stack2.push(q);
                // 前序遍历
                if(stack1.peek() == null || stack2.peek() == null ||  stack1.peek().val != stack2.peek().val){
                    return false;
                }
//                values.add(p.val);
                p = p.left;
                q = q.left;
            }
            p = stack1.peek();
            q = stack2.peek();
            stack1.pop();
            stack2.pop();
            p = p.right;
            q = q.right;
        }
        if(p != q){
            return false;
        }
        return true;
    }

    /**
     * 使用递归实现操作
     * @param p
     * @param q
     * @return
     */
    public static boolean isSameTree1(TreeNode p, TreeNode q) {
        if(p == null && q == null){
            return true;
        }else if(p== null || q == null){
            return false;
        }else if(p.val != q.val){
            return false;
        }else {
            return isSameTree1(p.left,q.left) && isSameTree1(p.right,q.right);
        }
    }



    public static void main(String[] args) {
//        TreeNode p = NodeUtil.createTreeNodeByArr(new int[]{1, 2, 3,4,5,6,7});
//        TreeNode q = NodeUtil.createTreeNodeByArr(new int[]{1, 2, 3,4,5,6,7});
        TreeNode p = NodeUtil.createTreeNodeByArr(new int[]{1,2,3,4,5});
        TreeNode q = NodeUtil.createTreeNodeByArr(new int[]{1,2,3,4,5});
//        TreeNode p = NodeUtil.createTreeNodeByArr(new int[]{1});
//        TreeNode q = NodeUtil.createTreeNodeByArr(new int[]{});
        System.out.println(isSameTree1(p,q));
    }
}
